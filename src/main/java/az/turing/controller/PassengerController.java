package az.turing.controller;

import az.turing.model.PassengerDto;
import az.turing.service.inter.PassengerService;

import java.util.List;

public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public PassengerDto create(PassengerDto passengerDto) {
        return passengerService.create(passengerDto);
    }

    public PassengerDto update(PassengerDto passengerDto) {
        return passengerService.update(passengerDto);
    }

    public PassengerDto delete(long id) {
        return passengerService.delete(id);
    }

    public PassengerDto getId(long id) {
        return passengerService.getById(id);
    }

    public List<PassengerDto> getAll() {
        return passengerService.getAll();
    }
}
