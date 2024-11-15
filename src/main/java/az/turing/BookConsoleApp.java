package az.turing;

import az.turing.config.ConnectionHelper;
import az.turing.controller.FlightController;
import az.turing.dao.impl.database.FlightDao;
import az.turing.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;
import az.turing.mapper.FlightMapper;
import az.turing.menu.Menu;
import az.turing.service.impl.FligthServiceImpl;
import az.turing.service.inter.FlightService;

public class BookConsoleApp {
    public static void main(String[] args) {

        Flight flight = new Flight(5, "Baki", "Kiyev", "2024-11-19 15:00:00", 100, 40);

        ConnectionHelper connectionHelper = new ConnectionHelper();
        FlightDaoInter flightDaoInter = new FlightDao(connectionHelper);
        flightDaoInter.create(flight);
        //flightDaoInter.delete(16);
        FlightMapper entityMapper = new FlightMapper();
        FlightService flightService = new FligthServiceImpl(flightDaoInter, entityMapper);
        FlightController flightController = new FlightController(flightService);
        Menu menu = new Menu(flightController);


    }
}
