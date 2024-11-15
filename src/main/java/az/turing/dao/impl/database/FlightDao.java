package az.turing.dao.impl.database;

import az.turing.config.ConnectionHelper;
import az.turing.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlightDao extends FlightDaoInter {
    private final ConnectionHelper connectionHelper;

    public FlightDao(ConnectionHelper connectionHelper) {
        this.connectionHelper = connectionHelper;
    }

    @Override
    public Flight create(Flight flight) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into flights (flight_start_from,flight_from_to,flight_time,flight_totalseats,flight_availableseats) " +
                    "values(?,?,?,?,?)");
            preparedStatement.setString(1, flight.getFlightStartFrom());
            preparedStatement.setString(2, flight.getFlightFromTo());
            preparedStatement.setObject(3, flight.getLocalDateTime());
            preparedStatement.setInt(4, flight.getFlightTotalSeats());
            preparedStatement.setInt(5, flight.getFlightAvailableSeats());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " row inserted To Flights!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update flights set flight_start_from=?,flight_from_to=?,flight_time=?" +
                    ",flight_totalseats=?,flight_availableseats=? where flight_id=?");
            preparedStatement.setString(1, flight.getFlightStartFrom());
            preparedStatement.setString(2, flight.getFlightFromTo());
            preparedStatement.setObject(3, flight.getLocalDateTime());
            preparedStatement.setInt(4, flight.getFlightTotalSeats());
            preparedStatement.setInt(5, flight.getFlightAvailableSeats());
            preparedStatement.setInt(6, flight.getFlightId());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " row updated in Flights!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }

    @Override
    public Flight delete(Integer id) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from  flights where flight_id=?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " row deleted in Flights!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Flight getId(Integer id) {
        Flight flight = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from flights where flight_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flight = getFlight(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public Collection<Flight> getAll() {
        List<Flight> flightList = new ArrayList<>();
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from flights");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flightList.add(getFlight(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public Flight getFlight(ResultSet resultSet) throws SQLException {
        int flightId = resultSet.getInt("flight_id");
        String flightStartFrom = resultSet.getString("flight_start_from");
        String flightFromTo = resultSet.getString("flight_from_to");
        String flightTime = resultSet.getString("flight_time");
        int flightTotalSeats = resultSet.getInt("flight_totalseats");
        int flightAvailableSeats = resultSet.getInt("flight_availableseats");
        return new Flight(flightId, flightStartFrom, flightFromTo, flightTime, flightTotalSeats, flightAvailableSeats);
    }
}
