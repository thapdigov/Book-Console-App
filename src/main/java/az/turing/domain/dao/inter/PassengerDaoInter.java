package az.turing.domain.dao.inter;

import az.turing.domain.dao.Dao;
import az.turing.entity.Flight;
import az.turing.entity.Passenger;

import java.time.LocalDateTime;

public abstract class PassengerDaoInter implements Dao<Passenger, Long> {

    public abstract boolean existsById(Long id);

    public abstract boolean existsByNameAndSurname(String name, String surname);
}
