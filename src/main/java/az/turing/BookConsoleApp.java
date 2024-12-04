package az.turing;

import az.turing.config.ConnectionHelper;
import az.turing.controller.BookFlightController;
import az.turing.controller.BookPassengerController;
import az.turing.controller.FlightController;
import az.turing.domain.dao.impl.database.BookPassengerPostgres;
import az.turing.domain.dao.impl.database.BookPostgres;
import az.turing.domain.dao.impl.database.FlightDaoPostgres;
import az.turing.domain.dao.impl.database.PassengerPostgres;
import az.turing.domain.dao.inter.BookFlightDaoInter;
import az.turing.domain.dao.inter.BookPassengerDaoInter;
import az.turing.domain.dao.inter.FlightDaoInter;
import az.turing.domain.dao.inter.PassengerDaoInter;
import az.turing.mapper.BookFlightMapper;
import az.turing.mapper.BookPassengerMapper;
import az.turing.mapper.FlightMapper;
import az.turing.mapper.PassengerMapper;
import az.turing.menu.Menu;
import az.turing.service.impl.BookFlightServiceImpl;
import az.turing.service.impl.BookPassengerServiceImpl;
import az.turing.service.impl.FligthServiceImpl;
import az.turing.service.inter.BookFlightService;
import az.turing.service.inter.BookPassengerService;
import az.turing.service.inter.FlightService;

public class BookConsoleApp {
    public static void main(String[] args) {

        ConnectionHelper connectionHelper = new ConnectionHelper();
        FlightDaoInter flightDaoInter = new FlightDaoPostgres(connectionHelper);
        FlightMapper flightMapper = new FlightMapper();
        FlightService flightService = new FligthServiceImpl(flightDaoInter, flightMapper);
        FlightController flightController = new FlightController(flightService);
        BookPassengerDaoInter bookPassengerDaoInter = new BookPassengerPostgres();
        BookPassengerMapper bookPassengerMapper = new BookPassengerMapper();
        BookPassengerService bookPassengerService = new BookPassengerServiceImpl(bookPassengerDaoInter,
                bookPassengerMapper);
        BookPassengerController bookPassengerController = new BookPassengerController(bookPassengerService);
        PassengerMapper passengerMapper = new PassengerMapper();
        PassengerDaoInter passengerDaoInter = new PassengerPostgres(connectionHelper);
        BookFlightDaoInter bookFlightDaoInter = new BookPostgres(connectionHelper);
        BookFlightMapper bookFlightMapper = new BookFlightMapper();
        BookFlightServiceImpl bookFlightService = new BookFlightServiceImpl(bookFlightDaoInter, bookFlightMapper);
        BookFlightController bookFlightController = new BookFlightController(bookFlightService);
        Menu menu = new Menu(flightController, bookPassengerController, flightMapper, passengerMapper,
                flightDaoInter, passengerDaoInter, bookFlightController);
    }
}

