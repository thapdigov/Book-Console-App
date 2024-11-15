package az.turing.menu;

import az.turing.controller.FlightController;
import az.turing.entity.Flight;
import az.turing.exception.MenuException;
import az.turing.model.response.FlightResponse;
import az.turing.util.InputUtil;

import java.util.List;

public class Menu {
    public InputUtil inputUtil = new InputUtil();
    private final FlightController flightController;

    public Menu(FlightController flightController) {
        this.flightController = flightController;
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
                    System.out.println("ID - DEPARTURPOİNT - DESTİNATİONPOİNT -   DEPARTURTIME - \t\t\tTOTALSEATS - \tAVAILABLESEATS");
                    List<FlightResponse> flightResponses = flightController.getAll();
                    if (flightResponses.isEmpty()) {
                        continue;
                    }
                    for (FlightResponse flightRespons : flightResponses) {
                        flightInfo(flightRespons);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
        System.out.println(flight.getFlightId() + " \t- " + flight.getFlightStartFrom() + "\t\t\t\t- " + flight.getFlightFromTo() + " \t\t- " +
                flight.getLocalDateTime() + " \t\t- " + flight.getFlightTotalSeats() + " \t\t\t\t- " + flight.getFlightAvailableSeats());
    }
}
