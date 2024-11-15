package az.turing.service.impl;

import az.turing.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;
import az.turing.mapper.FlightMapper;
import az.turing.model.response.FlightResponse;
import az.turing.service.inter.FlightService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FligthServiceImpl implements FlightService {
    private final FlightDaoInter flightDaoInter;
    private final FlightMapper flightMapper;

    public FligthServiceImpl(FlightDaoInter flightDaoInter, FlightMapper flightMapper) {
        this.flightDaoInter = flightDaoInter;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightResponse> getFlightResponse() {
        List<FlightResponse> flightResponses = new ArrayList<>();
        Collection<Flight> flightList = flightDaoInter.getAll();
        for (Flight flight : flightList) {
            flightResponses.add(flightMapper.toResponse(flight));
        }
        return flightResponses;
    }
}
