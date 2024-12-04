package az.turing.service.impl;

import az.turing.domain.dao.inter.PassengerDaoInter;
import az.turing.entity.Passenger;
import az.turing.exception.AlreadyException;
import az.turing.exception.NotFoundException;
import az.turing.mapper.PassengerMapper;
import az.turing.model.PassengerDto;
import az.turing.service.inter.PassengerService;

import java.util.List;
import java.util.Optional;

public class PassengerServiceImpl implements PassengerService {
    private final PassengerDaoInter passengerDaoInter;
    private final PassengerMapper passengerMapper;

    public PassengerServiceImpl(PassengerDaoInter passengerDaoInter, PassengerMapper passengerMapper) {
        this.passengerDaoInter = passengerDaoInter;
        this.passengerMapper = passengerMapper;
    }

    @Override
    public PassengerDto create(PassengerDto passengerDto) {
        if (passengerDaoInter.existsByNameAndSurname(passengerDto.getName(), passengerDto.getSurname())) {
            throw new AlreadyException("Passenger already exists!");
        }
        return passengerMapper.toDto(passengerDaoInter.create(passengerMapper.toEnt(passengerDto)));
    }

    @Override
    public PassengerDto update(PassengerDto passengerDto) {
        return passengerMapper.toDto(passengerDaoInter.update(passengerMapper.toEnt(passengerDto)));
    }

    @Override
    public PassengerDto delete(long id) {
        return Optional.ofNullable
                (passengerMapper.toDto(passengerDaoInter.delete(id))).orElseThrow(() -> new NotFoundException("Id not found!"));
    }

    @Override
    public PassengerDto getById(long id) {
        return passengerMapper.toDto(passengerDaoInter.getId(id));
    }

    @Override
    public List<PassengerDto> getAll() {
        return passengerDaoInter.getAll().stream().map(passengerMapper::toDto).toList();
    }
}
