package az.turing.controller;

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
}
