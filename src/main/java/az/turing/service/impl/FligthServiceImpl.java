package az.turing.service.impl;

import az.turing.domain.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;
import az.turing.exception.AlreadyException;
import az.turing.mapper.FlightMapper;
import az.turing.model.request.FlightDto;
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

    @Override
    public FlightResponse getFlightResponse(Long id) {
        Flight flight = flightDaoInter.getId(id);
        return flight != null ? flightMapper.toResponse(flight) : null;
    }

    @Override
    public FlightResponse create(FlightDto flightDto) {
        if (flightDaoInter.existsTimeAndDestionation(flightDto.getFlightFromTo(), flightDto.getLocalDateTime())) {
            throw new AlreadyException("FLight already Contains!");
        }
        Flight flight = flightDaoInter.create(flightMapper.toEnt(flightDto));
        return flightMapper.toResponse(flight);
    }

    @Override
    public FlightResponse deleteById(long id) {
        Flight flight = flightDaoInter.delete(id);
        if (flight != null) {
            return flightMapper.toResponse(flight);
        } else {
            throw new IllegalArgumentException("Id not found!");
        }
    }

    @Override
    public FlightResponse update(FlightDto flightDto) {
        Flight flight = flightDaoInter.update(flightMapper.toEnt(flightDto));
        return flightMapper.toResponse(flight);
    }
}
