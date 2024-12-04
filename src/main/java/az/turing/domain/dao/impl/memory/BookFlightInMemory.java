package az.turing.domain.dao.impl.memory;

import az.turing.domain.dao.inter.BookFlightDaoInter;
import az.turing.entity.BookFlight;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookFlightInMemory extends BookFlightDaoInter {
    Map<Long, BookFlight> bookMap = new HashMap<>();

    @Override
    public BookFlight create(BookFlight bookFlight) {
        bookMap.put(bookFlight.getBookId(), bookFlight);
        return bookFlight;
    }

    @Override
    public BookFlight delete(Long id) {
        BookFlight bookFlight = bookMap.get(id);
        bookFlight.setActive(false);
        return update(bookFlight);
    }

    @Override
    public BookFlight update(BookFlight bookFlight) {
        return bookMap.put(bookFlight.getBookId(), bookFlight);
    }

    @Override
    public BookFlight getId(Long id) {
        return bookMap.get(id);
    }

    @Override
    public Collection<BookFlight> getAll() {
        return bookMap.values();
    }

    @Override
    public boolean existsByFlightId(Long id) {
        return bookMap.values().stream().anyMatch(book -> book.getBookId().equals(id));
    }

    @Override
    public String bookingInfo(BookFlight bookFlight) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tFlight: ").append("\n").append("\t\t").append(bookFlight.getFlightId().toString()).append("\n\t\t");
        return stringBuilder.toString();
    }
}
