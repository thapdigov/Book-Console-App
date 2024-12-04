package az.turing.model.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightResponse {
    private String flightStartFrom;
    private String flightFromTo;
    private LocalDateTime localDateTime;
    private int flightAvailableSeats;

    public FlightResponse() {
    }

    public FlightResponse(String flightStartFrom, String flightFromTo, String localDateTime, int flightTotalSeats, int flightAvailableSeats) {
        this.flightStartFrom = flightStartFrom;
        this.flightFromTo = flightFromTo;
        this.localDateTime = LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.flightAvailableSeats = flightAvailableSeats;
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

    public int getFlightAvailableSeats() {
        return flightAvailableSeats;
    }

    public void setFlightAvailableSeats(int flightAvailableSeats) {
        this.flightAvailableSeats = flightAvailableSeats;
    }

    @Override
    public String toString() {
        return "FlightResponse{" +
                ", flightStartFrom='" + flightStartFrom + '\'' +
                ", flightFromTo='" + flightFromTo + '\'' +
                ", localDateTime=" + localDateTime +
                ", flightAvailableSeats=" + flightAvailableSeats +
                '}';
    }
}
