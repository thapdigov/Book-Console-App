package az.turing.model.request;

import java.time.LocalDateTime;

public class FlightRequestDto {
    private  int flightId;
    private String flightStartFrom;
    private String flightFromTo;
    private LocalDateTime localDateTime;
    private int flightTotalSeats;
    private int flightAvailableSeats;

    public FlightRequestDto(int flightId) {
        this.flightId = flightId;
    }

    public FlightRequestDto(int flightId, String flightStartFrom, String flightFromTo, LocalDateTime localDateTime, int flightTotalSeats, int flightAvailableSeats) {
        this.flightId = flightId;
        this.flightStartFrom = flightStartFrom;
        this.flightFromTo = flightFromTo;
        this.localDateTime = localDateTime;
        this.flightTotalSeats = flightTotalSeats;
        this.flightAvailableSeats = flightAvailableSeats;
    }

    public FlightRequestDto() {
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
