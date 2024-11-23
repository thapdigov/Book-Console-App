package az.turing.domain.dao.impl.database;

import az.turing.config.ConnectionHelper;
import az.turing.domain.dao.inter.BookPassengerDaoInter;
import az.turing.entity.BookPassenger;
import az.turing.exception.AlreadyException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookPassengerPostgres extends BookPassengerDaoInter {

    ConnectionHelper connectionHelper = new ConnectionHelper();

    @Override
    public BookPassenger create(BookPassenger bookPassenger) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into BookPassengers (book_id,passenger_id) values(?,?)");
            preparedStatement.setLong(1, bookPassenger.getBookId());
            preparedStatement.setLong(2, bookPassenger.getPassengerId());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " row inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookPassenger;
    }

    @Override
    public BookPassenger delete(Long id) {
        BookPassenger bookPassenger = getId(id);
        if (bookPassenger == null) {
            throw new AlreadyException("ID not found -" + id);
        }
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from BookPassengers where book_id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookPassenger = getBookPassenger(resultSet);
            }
            PreparedStatement pr = connection.prepareStatement("delete from BookPassengers where book_id=?");
            pr.setLong(1, id);
            int i = pr.executeUpdate();
            System.out.println(i + " row deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookPassenger;
    }

    @Override
    public BookPassenger update(BookPassenger bookPassenger) {
        BookPassenger bookPassenger1 = getId(bookPassenger.getBookId());
        if (bookPassenger1 == null) {
            throw new IllegalArgumentException("Id not found! " + bookPassenger.getBookId());
        }
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update BookPassengers set book_id=? where passenger_id=?");
            preparedStatement.setLong(1, bookPassenger.getBookId());
            preparedStatement.setLong(2, bookPassenger.getPassengerId());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " row updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookPassenger;
    }

    @Override
    public BookPassenger getId(Long id) {
        BookPassenger bookPassenger = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from BookPassengers where book_id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookPassenger = getBookPassenger(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookPassenger;
    }

    @Override
    public Collection<BookPassenger> getAll() {
        List<BookPassenger> list = new ArrayList<>();
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from BookPassengers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(getBookPassenger(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BookPassenger getBookPassenger(ResultSet resultSet) throws SQLException {
        Long bId = resultSet.getLong("book_id");
        Long pId = resultSet.getLong("passenger_id");
        return new BookPassenger(bId, pId);

    }
}
