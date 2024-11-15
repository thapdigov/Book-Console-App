package az.turing.mapper;

import az.turing.entity.Flight;
import az.turing.model.request.FlightRequestDto;
import az.turing.model.response.FlightResponse;

public class FlightMapper implements EntityMapper<Flight, FlightRequestDto> {
    @Override
    public Flight toEnt(FlightRequestDto flightRequestDto) {
        Flight flight = new Flight();
        flight.setFlightId(flightRequestDto.getFlightId());
        flight.setFlightStartFrom(flightRequestDto.getFlightStartFrom());
        flight.setFlightFromTo(flightRequestDto.getFlightFromTo());
        flight.setFlightTotalSeats(flightRequestDto.getFlightTotalSeats());
        flight.setFlightAvailableSeats(flightRequestDto.getFlightAvailableSeats());
        return flight;
    }

    @Override
    public FlightRequestDto toDto(Flight flight) {
        FlightRequestDto flightRequestDto = new FlightRequestDto();
        flightRequestDto.setFlightId(flight.getFlightId());
        flightRequestDto.setFlightStartFrom(flight.getFlightStartFrom());
        flightRequestDto.setFlightFromTo(flight.getFlightFromTo());
        flightRequestDto.setFlightTotalSeats(flight.getFlightTotalSeats());
        flightRequestDto.setFlightAvailableSeats(flight.getFlightAvailableSeats());
        return flightRequestDto;
    }

    public FlightResponse toResponse(Flight flight) {
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setFlightId(flight.getFlightId());
        flightResponse.setFlightStartFrom(flight.getFlightStartFrom());
        flightResponse.setFlightFromTo(flight.getFlightFromTo());
        flightResponse.setLocalDateTime(flight.getLocalDateTime());
        flightResponse.setFlightTotalSeats(flight.getFlightTotalSeats());
        flightResponse.setFlightAvailableSeats(flight.getFlightAvailableSeats());
        return flightResponse;
    }
}
