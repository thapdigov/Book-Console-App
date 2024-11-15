package az.turing.service.inter;

import az.turing.model.response.FlightResponse;

import java.util.List;

public interface FlightService {
    List<FlightResponse> getFlightResponse();
}
