package az.turing.domain.dao.impl.database;

import az.turing.config.ConnectionHelper;
import az.turing.domain.dao.inter.BookFlightDaoInter;
import az.turing.entity.BookFlight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookPostgres extends BookFlightDaoInter {

    private final ConnectionHelper connectionHelper;

    public BookPostgres(ConnectionHelper connectionHelper) {
        this.connectionHelper = connectionHelper;
    }

    @Override
    public BookFlight create(BookFlight bookFlight) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Book (book_id,bflight_id,isActive) values(?,?,?)");
            preparedStatement.setLong(1, bookFlight.getBookId());
            preparedStatement.setLong(2, bookFlight.getFlightId());
            preparedStatement.setBoolean(3, bookFlight.isActive());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + "row inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookFlight;
    }

    @Override
    public BookFlight delete(Long id) {
        BookFlight bookFlight = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from Book where book_id=?;");
            preparedStatement1.setLong(1,id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                bookFlight = getBook(resultSet);
            }
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Book where book_id=?;");
            preparedStatement.setLong(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i + "row deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookFlight;
    }

    @Override
    public BookFlight update(BookFlight bookFlight) {
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update Book set bflight_id=?,isActive=? where book_id=?;");
            preparedStatement.setLong(1, bookFlight.getFlightId());
            preparedStatement.setBoolean(2, bookFlight.isActive());
            preparedStatement.setLong(3, bookFlight.getBookId());
            int i = preparedStatement.executeUpdate();
            System.out.println(i + "row updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookFlight;
    }

    @Override
    public BookFlight getId(Long id) {
        BookFlight bookFlight = null;
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Book where book_id=?;");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookFlight = getBook(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookFlight;
    }

    @Override
    public Collection<BookFlight> getAll() {
        List<BookFlight> list = new ArrayList<>();
        try (Connection connection = connectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Book");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(getBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean existsByFlightId(Long id) {
        return getAll().stream().anyMatch(book -> book.getBookId().equals(id));
    }

    @Override
    public String bookingInfo(BookFlight bookFlight) {
        return null;
    }

    public BookFlight getBook(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("book_id");
        Long fId = resultSet.getLong("bflight_id");
        boolean isActive = resultSet.getBoolean("isActive");
        return new BookFlight(id, fId, isActive);
    }

}
