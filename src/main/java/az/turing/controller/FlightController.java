package az.turing.controller;

import az.turing.model.request.FlightDto;
import az.turing.model.response.FlightResponse;
import az.turing.service.inter.FlightService;

import java.util.List;

public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public List<FlightResponse> getAll() {
        return flightService.getFlightResponse();
    }

    public FlightResponse getById(long id) {
        return flightService.getFlightResponse(id);
    }

    public FlightResponse create(FlightDto flightDto) {
        return flightService.create(flightDto);
    }

    public FlightResponse delete(long id) {
        return flightService.deleteById(id);
    }

    public FlightResponse update(FlightDto flightDto) {
        return flightService.update(flightDto);
    }
}
