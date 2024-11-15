package az.turing.model.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightResponse {
    private  int flightId;
    private String flightStartFrom;
    private String flightFromTo;
    private LocalDateTime localDateTime;
    private int flightTotalSeats;
    private int flightAvailableSeats;

    public FlightResponse() {
    }

    public FlightResponse(int flightId, String flightStartFrom, String flightFromTo, String localDateTime, int flightTotalSeats, int flightAvailableSeats) {
        this.flightId = flightId;
        this.flightStartFrom = flightStartFrom;
        this.flightFromTo = flightFromTo;
        this.localDateTime = LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.flightTotalSeats = flightTotalSeats;
        this.flightAvailableSeats = flightAvailableSeats;
    }

    public int getFlightId() {
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
        return "FlightResponse{" +
                "flightId=" + flightId +
                ", flightStartFrom='" + flightStartFrom + '\'' +
                ", flightFromTo='" + flightFromTo + '\'' +
                ", localDateTime=" + localDateTime +
                ", flightTotalSeats=" + flightTotalSeats +
                ", flightAvailableSeats=" + flightAvailableSeats +
                '}';
    }
}