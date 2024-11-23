package az.turing.domain.dao.impl.memory;

import az.turing.domain.dao.inter.BookPassengerDaoInter;
import az.turing.entity.BookPassenger;
import az.turing.exception.AlreadyException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookPassengerInMemory extends BookPassengerDaoInter {

    private final Map<Long, BookPassenger> bookPassengerMap = new HashMap<>();

    @Override
    public BookPassenger create(BookPassenger bookPassenger) {
        if (bookPassengerMap.containsKey(bookPassenger.getPassengerId())) {
            throw new AlreadyException("Passenger with this ID already exists!");
        }
        bookPassengerMap.put(bookPassenger.getPassengerId(), bookPassenger);
        return bookPassenger;
    }

    @Override
    public BookPassenger delete(Long id) {
        return Optional.ofNullable(bookPassengerMap.remove(id))
                .orElseThrow(() -> new AlreadyException("Passenger with ID " + id + " not found!"));
    }

    @Override
    public BookPassenger update(BookPassenger bookPassenger) {
        if (!bookPassengerMap.containsKey(bookPassenger.getPassengerId())) {
            throw new AlreadyException("Passenger with this ID does not exist!");
        }
        bookPassengerMap.put(bookPassenger.getPassengerId(), bookPassenger);
        return bookPassenger;
    }

    @Override
    public BookPassenger getId(Long id) {
        return Optional.ofNullable(bookPassengerMap.get(id))
                .orElseThrow(() -> new AlreadyException("Passenger with ID " + id + " not found!"));
    }

    @Override
    public Collection<BookPassenger> getAll() {
        return bookPassengerMap.values();
    }
}
