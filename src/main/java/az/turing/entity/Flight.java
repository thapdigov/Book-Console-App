package az.turing.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight {
    private Integer flightId;
    private String flightStartFrom;
    private String flightFromTo;
    private LocalDateTime localDateTime;
    private Integer flightTotalSeats;
    private Integer flightAvailableSeats;

    public Flight() {
    }

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Flight(Integer flightId, String flightStartFrom, String flightFromTo, String localDateTime, Integer flightTotalSeats, Integer flightAvailableSeats) {
        this.flightId = flightId;
        this.flightStartFrom = flightStartFrom;
        this.flightFromTo = flightFromTo;
        this.localDateTime = LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.flightTotalSeats = flightTotalSeats;
        this.flightAvailableSeats = flightAvailableSeats;
    }

    public Flight(Integer flightId, String flightStartFrom, String flightFromTo, Integer flightTotalSeats, Integer flightAvailableSeats) {
        this.flightId = flightId;
        this.flightStartFrom = flightStartFrom;
        this.flightFromTo = flightFromTo;
        this.flightTotalSeats = flightTotalSeats;
        this.flightAvailableSeats = flightAvailableSeats;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightStartFrom() {
        return flightStartFrom;
    }

    public void setFlightStartFrom(String flightStartFrom) {
        this.flightStartFrom = flightStartFrom;
    }

    public String getFlightFromTo() {
        return flightFromTo;
    }

    public void setFlightFromTo(String flightFromTo) {
        this.flightFromTo = flightFromTo;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getFlightTotalSeats() {
        return flightTotalSeats;
    }

    public void setFlightTotalSeats(Integer flightTotalSeats) {
        this.flightTotalSeats = flightTotalSeats;
    }

    public Integer getFlightAvailableSeats() {
        return flightAvailableSeats;
    }

    public void setFlightAvailableSeats(Integer flightAvailableSeats) {
        this.flightAvailableSeats = flightAvailableSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId.equals(flight.flightId) && flightStartFrom.equals(flight.flightStartFrom) && flightFromTo.equals(flight.flightFromTo) && Objects.equals(localDateTime, flight.localDateTime) && Objects.equals(flightTotalSeats, flight.flightTotalSeats) && Objects.equals(flightAvailableSeats, flight.flightAvailableSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightStartFrom, flightFromTo, localDateTime, flightTotalSeats, flightAvailableSeats);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightStartFrom='" + flightStartFrom + '\'' +
                ", flightFromTo='" + flightFromTo + '\'' +
                ", localDateTime=" + localDateTime +
                ", flightTotalSeats=" + flightTotalSeats +
                ", flightAvailableSeats=" + flightAvailableSeats +
                '}';
    }
}
