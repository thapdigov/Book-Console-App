package az.turing.entity;

import java.io.Serializable;

public class BookFlight implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long bookId;
    private Long flightId;
    private boolean isActive;

    public BookFlight(Long bookId) {
        this.bookId = bookId;
    }

    public BookFlight(Long bookId, Long flightId, boolean isActive) {
        this.bookId = bookId;
        this.flightId = flightId;
        this.isActive = isActive;
    }

    public BookFlight(long flightId, boolean active) {
        this.flightId = flightId;
        this.isActive = active;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlight(Long flightId) {
        this.flightId = flightId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Book \n" +
                "\t\tbookId: " + bookId +
                " ,flight= " + flightId +
                " ,isActive=" + isActive;
    }
}
