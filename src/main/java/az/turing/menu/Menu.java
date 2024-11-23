package az.turing.menu;

import az.turing.controller.BookFlightController;
import az.turing.controller.BookPassengerController;
import az.turing.controller.FlightController;
import az.turing.domain.dao.inter.FlightDaoInter;
import az.turing.domain.dao.inter.PassengerDaoInter;
import az.turing.entity.Flight;
import az.turing.entity.Passenger;
import az.turing.exception.MenuException;
import az.turing.mapper.FlightMapper;
import az.turing.mapper.PassengerMapper;
import az.turing.model.BookFlightDto;
import az.turing.model.BookPassengerDto;
import az.turing.model.PassengerDto;
import az.turing.model.response.FlightResponse;
import az.turing.util.InputUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Menu {
    public InputUtil inputUtil = new InputUtil();
    private final FlightController flightController;
    private final FlightMapper flightMapper;
    private final FlightDaoInter flightDaoInter;
    private final BookPassengerController bookPassengerController;
    private final PassengerMapper passengerMapper;
    private final PassengerDaoInter passengerDaoInter;
    private final BookFlightController bookFlightController;

    public Menu(FlightController flightController, BookPassengerController bookPassengerController,
                FlightMapper flightMapper, PassengerMapper passengerMapper, FlightDaoInter flightDaoInter,
                PassengerDaoInter passengerDaoInter, BookFlightController bookFlightController) {
        this.flightController = flightController;
        this.bookPassengerController = bookPassengerController;
        this.flightMapper = flightMapper;
        this.passengerMapper = passengerMapper;
        this.flightDaoInter = flightDaoInter;
        this.passengerDaoInter = passengerDaoInter;
        this.bookFlightController = bookFlightController;
        displayMenu();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Choose the select menu!");
            int menu = inputUtil.getInteger(
                    """
                            1.Online Board
                            2.Show The Flight Info
                            3.Search and book a flight
                            4.Cancel the booking
                            5.My flights
                            6.Exit
                            """);
            switch (menu) {
                case 1:
                    System.out.println(" DEPARTURPOİNT    - DESTİNATİONPOİNT    -   \tDEPARTURTIME - \t\t\tAVAILABLESEATS");
                    List<FlightResponse> flightList = flightController.getAll();
                    if (flightList.isEmpty()) {
                        System.out.println("There are no flights available.");
                        continue;
                    }
                    boolean hasFlightsInLast24Hours = false;
                    for (FlightResponse flight : flightList) {
                        LocalDateTime now = LocalDateTime.now();
                        LocalDateTime flightTime = flight.getLocalDateTime();

                        Duration duration = Duration.between(flightTime, now);
                        if (Math.abs(duration.toHours()) <= 24) {
                            hasFlightsInLast24Hours = true;
                            flightInfo(flight);
                        }
                    }

                    if (!hasFlightsInLast24Hours) {
                        System.out.println("There is not flights in the last 24 hours!");
                    }
                    break;

                case 2:
                    int flightId = inputUtil.getInteger("Enter the flightId");
                    FlightResponse flightResponse = flightController.getById(flightId);
                    if (flightResponse != null) {
                        System.out.println("\t\tDEPARTURTIME  - \t\tDESTİNATİONPOİNT  - \t\tAVAILABLESEATS");
                        flightInfo1(flightResponse);
                    } else {
                        System.out.println("Flight not found due Id!");
                    }
                    break;
                case 3:
                    String destination = inputUtil.getString("Enter the destination you want to go");
                    String time = inputUtil.getString("Enter the flight time (yyyy-MM-dd HH:mm:ss)");
                    int availableSeats = inputUtil.getInteger("How many tickets do you want to buy?");
                    boolean flightFound = false;

                    for (Flight flight : flightDaoInter.getAll()) {
                        if (flight.getFlightFromTo().equals(destination)
                                && flight.getLocalDateTime().equals(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                && availableSeats <= flight.getFlightAvailableSeats()) {
                            flightFound = true;
                            System.out.println(flight);
                            int choice = inputUtil.getInteger("""
                                    Please,choose the menu
                                    1.Buy ticket
                                    2.Back to main menu
                                    """);
                            switch (choice) {
                                case 1 -> {
                                    for (int i = 0; i < availableSeats; i++) {
                                        String name = inputUtil.getString("Passenger name");
                                        String surName = inputUtil.getString("Passenger surname");
                                        PassengerDto passengerDto = new PassengerDto(name, surName);
                                        Passenger passenger = passengerDaoInter.create(passengerMapper.toEnt(passengerDto));
                                        bookPassengerController.create(new BookPassengerDto(passenger.getPassengerId(),flight.getFlightId()));
                                    }
                                    flight.setFlightAvailableSeats(flight.getFlightAvailableSeats() - availableSeats);
                                    flightController.update(flightMapper.toDto(flight));
                                    System.out.println("Tickets booked successfully!");
                                }
                                case 2 -> displayMenu();
                                default -> System.out.println("Invalid input!");
                            }
                        }
                    }
                    if (!flightFound) {
                        System.out.println("Flight not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter the information Passenger and Flight!");
                    int id = inputUtil.getInteger("Enter the bookId");
                    int pId = inputUtil.getInteger("Enter the passengerId you want to cancel Flight");
                    boolean passengerFlight = false;
                    for (BookPassengerDto bookPassengerDto : bookPassengerController.getAll()) {
                        if (bookPassengerDto.getBookId() == id && bookPassengerDto.getPassengerId() == pId) {
                            passengerFlight = true;
                            for (BookFlightDto bookFlightDto : bookFlightController.getAll()) {
                                if (bookFlightDto.getFlightId() == id) {
                                    bookFlightDto.setActive(false);
                                }
                            }

                        }
                        break;
                    }
                    if (!passengerFlight) {
                        System.out.println("There is not flight for PassengerId: " + id);
                    }
                    break;
                case 5:
                    int pID = inputUtil.getInteger("Enter the passengerId you want to see ");
                    List<BookPassengerDto> list = bookPassengerController.getAll().stream()
                            .filter(bookPassengerDto -> bookPassengerDto.getPassengerId()==pID).toList();
                    if (list.isEmpty()) {
                        System.out.println("There is not flight!");
                    }
                    for (BookPassengerDto bookPassengerDto : list) {
                        Optional<BookFlightDto> bookFlightDto = bookFlightController.getId(bookPassengerDto.getBookId());
                        if (bookFlightDto.isPresent() && bookFlightDto.get().isActive()) {
                            FlightResponse flight = flightController.getById(bookFlightDto.get().getFlightId());
                            if (flight != null) {
                                System.out.println(flight);
                            } else {
                                System.out.println("There is not flight " + bookPassengerDto.getPassengerId());
                            }
                        } else {
                            System.out.println("There is not flight or flight is not active!" + bookPassengerDto.getPassengerId());
                        }

                    }

                    break;
                case 6:
                    System.out.println("We are waiting again!");
                    System.exit(0);
                    break;
                default:
                    throw new MenuException("Menu not found!");
            }
        }

    }

    public void flightInfo(FlightResponse flight) {
        System.out.println(" \t- " + flight.getFlightStartFrom() + "\t\t\t\t- " + flight.getFlightFromTo() + " \t\t\t- " +
                flight.getLocalDateTime() + " \t\t- " + " \t\t- " + flight.getFlightAvailableSeats());

    }

    public void flightInfo1(FlightResponse flight) {
        System.out.println(" \t- " + flight.getLocalDateTime() + "\t\t\t- " + flight.getFlightFromTo() +
                "\t\t\t\t\t\t- " +
                flight.getFlightAvailableSeats());
    }
}
