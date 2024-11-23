package az.turing.service.inter;

import az.turing.model.request.FlightDto;
import az.turing.model.response.FlightResponse;

import java.util.List;

public interface FlightService {
    List<FlightResponse> getFlightResponse();

    FlightResponse getFlightResponse(Long id);

    FlightResponse create(FlightDto flightDto);

    FlightResponse deleteById(long id);

    FlightResponse update(FlightDto flightDto);
}
