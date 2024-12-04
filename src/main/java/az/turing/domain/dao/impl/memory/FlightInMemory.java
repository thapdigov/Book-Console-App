package az.turing.domain.dao.impl.memory;

import az.turing.domain.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlightInMemory extends FlightDaoInter {

    Map<Long, Flight> flightMap = new HashMap<>();

    @Override
    public Flight create(Flight flight) {
        if (existsById(flight.getFlightId())) {
            System.out.println("Flight already exists!");
            return null;
        }
        flightMap.put(flight.getFlightId(), flight);
        return flight;
    }

    @Override
    public Flight delete(Long id) {
        return flightMap.remove(id);
    }

    @Override
    public Flight update(Flight flight) {
        return flightMap.put(flight.getFlightId(), flight);
    }

    @Override
    public Flight getId(Long id) {
        return flightMap.get(id);
    }

    @Override
    public Collection<Flight> getAll() {
        return flightMap.values();
    }

    @Override
    public boolean existsTimeAndDestionation(String destionation, LocalDateTime time) {
        for (Flight flight : getAll()) {
            if (flight.getFlightFromTo().equals(destionation) && flight.getLocalDateTime().equals(time)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return flightMap.containsKey(id);
    }
}
