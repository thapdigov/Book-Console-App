package az.turing.domain.dao.impl.database;

import az.turing.config.ConnectionHelper;
import az.turing.domain.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlightDaoPostgres extends FlightDaoInter {
    private final ConnectionHelper connectionHelper;

    public FlightDaoPostgres(ConnectionHelper connectionHelper) {
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
            if (i > 0) {
                System.out.println(i + " row inserted To Flights!");
            } else {
                System.out.println("Not insert to table ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update flights set flight_from_to=?,flight_time=?" +
                    ",flight_totalseats=?,flight_availableseats=? where flight_from_to=?");
            preparedStatement.setString(1, flight.getFlightFromTo());
            preparedStatement.setObject(2, flight.getLocalDateTime());
            preparedStatement.setInt(3, flight.getFlightTotalSeats());
            preparedStatement.setInt(4, flight.getFlightAvailableSeats());
            preparedStatement.setString(5, flight.getFlightFromTo());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " row updated in Flights!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public Flight delete(Long id) {
        Flight flight = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from  flights where flight_id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                flight = getFlight(rs);
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement("delete from  flights where flight_id=?");
            preparedStatement1.setLong(1, id);
            int i = preparedStatement1.executeUpdate();
            System.out.println(i + " row deleted in Flights!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public Flight getId(Long id) {
        Flight flight = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from flights where flight_id=?");
            preparedStatement.setLong(1, id);
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
        Long flightId = resultSet.getLong("flight_id");
        String flightFromTo = resultSet.getString("flight_from_to");
        String flightTime = resultSet.getString("flight_time");
        int flightTotalSeats = resultSet.getInt("flight_totalseats");
        int flightAvailableSeats = resultSet.getInt("flight_availableseats");
        return new Flight(flightId, flightFromTo, flightTime, flightTotalSeats, flightAvailableSeats);
    }

    @Override
    public boolean existsTimeAndDestionation(String destination, LocalDateTime flightTime) {
        for (Flight flight : getAll()) {
            if (flight.getFlightFromTo().equals(destination) && flight.getLocalDateTime().equals(flightTime)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        for (Flight flight : getAll()) {
            if (flight.getFlightId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
