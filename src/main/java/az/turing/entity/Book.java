package az.turing.entity;

import java.util.List;

public class Book {
    private Integer bookId;
    private Flight flight;
    private boolean isActive;
    private List<Passenger> passengerList;

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Flight flight, boolean isActive, List<Passenger> passengerList) {
        this.flight = flight;
        this.isActive = isActive;
        this.passengerList = passengerList;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", flight=" + flight +
                ", isActive=" + isActive +
                ", passengerList=" + passengerList +
                '}';
    }
}
