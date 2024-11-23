package az.turing.domain.dao.impl.file;

import az.turing.domain.dao.inter.PassengerDaoInter;
import az.turing.entity.Passenger;
import az.turing.util.FileUtil;

import java.util.Collection;
import java.util.List;

public class PassengerFile extends PassengerDaoInter {

    private final FileUtil<Passenger> fileUtil;

    public PassengerFile(FileUtil<Passenger> fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    public Passenger create(Passenger passenger) {
        List<Passenger> passengerList = fileUtil.ReadToFile();
        if (existsById(passenger.getPassengerId())) {
            System.out.println("Passenger already exists!");
            return null;
        }
        passengerList.add(passenger);
        fileUtil.WriteToFile(passengerList);
        return passenger;
    }

    @Override
    public Passenger delete(Long id) {
        return null;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger getId(Long id) {
        return null;
    }

    @Override
    public Collection<Passenger> getAll() {
        return fileUtil.ReadToFile();
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
