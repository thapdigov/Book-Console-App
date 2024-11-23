package az.turing.domain.dao.impl.database;

import az.turing.config.ConnectionHelper;
import az.turing.domain.dao.inter.PassengerDaoInter;
import az.turing.entity.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PassengerPostgres extends PassengerDaoInter {

    private final ConnectionHelper connectionHelper;

    public PassengerPostgres(ConnectionHelper connectionHelper) {
        this.connectionHelper = connectionHelper;
    }

    @Override
    public Passenger create(Passenger passenger) {
        if (existsById(passenger.getPassengerId())) {
            System.out.println("Passenger already exists! " + passenger);
            return null;
        }
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Passengers (passenger_name,passenger_surname) values(?,?)");
            preparedStatement.setString(1, passenger.getPassengerName());
            preparedStatement.setString(2, passenger.getPassengerSurname());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " passenger inserted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Passenger delete(Long id) {
        if (!existsById(id)) {
            System.out.println("Passenger id not found!");
            return null;
        }
        Passenger passenger = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from Passengers where passenger_id=?");
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                passenger = getPassenger(resultSet);
            }
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Passengers where passenger_id=?");
            preparedStatement.setLong(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " passenger deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger getId(Long id) {
        Passenger passenger = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from Passengers where passenger_id=?");
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                passenger = getPassenger(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    @Override
    public Collection<Passenger> getAll() {
        List<Passenger> passengerList = new ArrayList<>();
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from Passengers");
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                passengerList.add(getPassenger(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengerList;
    }

    @Override
    public boolean existsById(Long id) {
        return getAll().stream().anyMatch(passenger -> passenger.getPassengerId().equals(id));
    }

    @Override
    public boolean existsByNameAndSurname(String name, String surname) {
        return getAll().stream().anyMatch(passenger ->
                passenger.getPassengerName().equals(name) && passenger.getPassengerSurname().equals(surname));
    }

    public Passenger getPassenger(ResultSet resultSet) throws SQLException {
        Long passengerId = resultSet.getLong("passenger_id");
        String passengerName = resultSet.getString("passenger_name");
        String passengersurName = resultSet.getString("passenger_surname");
        return new Passenger(passengerId, passengerName, passengersurName);
    }
}
