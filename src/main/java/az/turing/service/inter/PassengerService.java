package az.turing.service.inter;

import az.turing.entity.Passenger;
import az.turing.model.PassengerDto;

import java.util.List;

public interface PassengerService {

    PassengerDto create(PassengerDto passenger);

    PassengerDto update(PassengerDto passenger);

    PassengerDto delete(long id);

    PassengerDto getById(long id);

    List<PassengerDto> getAll();
}
