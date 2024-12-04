package az.turing.model.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightDto {
    private long flightId;
    private String flightStartFrom;
    private String flightFromTo;
    private LocalDateTime localDateTime;
    private int flightTotalSeats;
    private int flightAvailableSeats;

    public FlightDto(long flightId) {
        this.flightId = flightId;
    }

    public FlightDto(String flightFromTo, String localDateTime, int flightTotalSeats, int flightAvailableSeats) {
        this.flightFromTo = flightFromTo;
        this.localDateTime = LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.flightTotalSeats = flightTotalSeats;
        this.flightAvailableSeats = flightAvailableSeats;
    }

    public FlightDto() {
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
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

    public int getFlightTotalSeats() {
        return flightTotalSeats;
    }

    public void setFlightTotalSeats(int flightTotalSeats) {
        this.flightTotalSeats = flightTotalSeats;
    }

    public int getFlightAvailableSeats() {
        return flightAvailableSeats;
    }

    public void setFlightAvailableSeats(int flightAvailableSeats) {
        this.flightAvailableSeats = flightAvailableSeats;
    }

    @Override
    public String toString() {
        return "FlightRequestDto{" +
                "flightId=" + flightId +
                ", flightStartFrom='" + flightStartFrom + '\'' +
                ", flightFromTo='" + flightFromTo + '\'' +
                ", localDateTime=" + localDateTime +
                ", flightTotalSeats=" + flightTotalSeats +
                ", flightAvailableSeats=" + flightAvailableSeats +
                '}';
    }
}
