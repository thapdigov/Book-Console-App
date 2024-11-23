package az.turing.domain.dao.inter;

import az.turing.domain.dao.Dao;
import az.turing.entity.BookFlight;

public abstract class BookFlightDaoInter implements Dao<BookFlight, Long> {
    public abstract boolean existsByFlightId(Long id);
    public abstract String bookingInfo(BookFlight bookFlight);
}
