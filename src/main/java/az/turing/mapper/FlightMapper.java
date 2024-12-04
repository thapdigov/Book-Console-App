package az.turing.mapper;

import az.turing.entity.Flight;
import az.turing.model.request.FlightDto;
import az.turing.model.response.FlightResponse;

public class FlightMapper implements EntityMapper<Flight, FlightDto> {
    @Override
    public Flight toEnt(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightId(flightDto.getFlightId());
        flight.setFlightFromTo(flightDto.getFlightFromTo());
        flight.setLocalDateTime(flightDto.getLocalDateTime());
        flight.setFlightTotalSeats(flightDto.getFlightTotalSeats());
        flight.setFlightAvailableSeats(flightDto.getFlightAvailableSeats());
        return flight;
    }

    @Override
    public FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightStartFrom(flight.getFlightStartFrom());
        flightDto.setFlightFromTo(flight.getFlightFromTo());
        flightDto.setLocalDateTime(flight.getLocalDateTime());
        flightDto.setFlightTotalSeats(flight.getFlightTotalSeats());
        flightDto.setFlightAvailableSeats(flight.getFlightAvailableSeats());
        return flightDto;
    }

    @Override
    public FlightResponse toResponse(Flight flight) {
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setFlightStartFrom(flight.getFlightStartFrom());
        flightResponse.setFlightFromTo(flight.getFlightFromTo());
        flightResponse.setLocalDateTime(flight.getLocalDateTime());
        flightResponse.setFlightAvailableSeats(flight.getFlightAvailableSeats());
        return flightResponse;
    }


}
