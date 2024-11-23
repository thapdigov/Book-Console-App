package az.turing.mapper;

import az.turing.entity.Passenger;
import az.turing.model.PassengerDto;

public class PassengerMapper implements EntityMapper<Passenger, PassengerDto> {


    @Override
    public Passenger toEnt(PassengerDto passengerDto) {
        return new Passenger(passengerDto.getName(), passengerDto.getSurname());
    }

    @Override
    public PassengerDto toDto(Passenger passenger) {
        return new PassengerDto(passenger.getPassengerName(), passenger.getPassengerSurname());
    }

    @Override
    public <R> R toResponse(Passenger passenger) {
        return null;
    }
}
