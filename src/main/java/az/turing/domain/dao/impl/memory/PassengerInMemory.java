package az.turing.domain.dao.impl.memory;

import az.turing.domain.dao.inter.PassengerDaoInter;
import az.turing.entity.Passenger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassengerInMemory extends PassengerDaoInter {

    public Map<Long, Passenger> passengerMap = new HashMap<>();


    @Override
    public Passenger create(Passenger passenger) {
        if (existsById(passenger.getPassengerId())) {
            System.out.println("Passenger already exists!");
            return null;
        }
        passengerMap.put(passenger.getPassengerId(), passenger);
        return null;
    }

    @Override
    public Passenger delete(Long id) {
        return passengerMap.remove(id);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerMap.put(passenger.getPassengerId(), passenger);
    }

    @Override
    public Passenger getId(Long id) {
        return passengerMap.get(id);
    }

    @Override
    public Collection<Passenger> getAll() {
        return passengerMap.values();
    }

    @Override
    public boolean existsById(Long id) {
        for (Passenger passenger : getAll()) {
            if (passenger.getPassengerId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsByNameAndSurname(String name, String surname) {
        return false;
    }
}
