package az.turing.domain.dao.inter;

import az.turing.domain.dao.Dao;
import az.turing.entity.Flight;

import java.time.LocalDateTime;

public abstract class FlightDaoInter implements Dao<Flight, Long> {

    public abstract boolean existsTimeAndDestionation(String destionation, LocalDateTime time);

    public abstract boolean existsById(Long id);
}
