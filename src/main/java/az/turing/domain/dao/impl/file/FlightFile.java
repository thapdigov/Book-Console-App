package az.turing.domain.dao.impl.file;

import az.turing.domain.dao.inter.FlightDaoInter;
import az.turing.entity.Flight;
import az.turing.util.FileUtil;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class FlightFile extends FlightDaoInter {
    public final FileUtil<Flight> fileUtil;

    public FlightFile(FileUtil<Flight> fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    public Flight create(Flight flight) {
        List<Flight> fLightList = fileUtil.ReadToFile();
        fLightList.add(flight);
        fileUtil.WriteToFile(fLightList);
        return flight;
    }

    @Override
    public Flight delete(Long id) {
        return null;
    }

    @Override
    public Flight update(Flight flight) {
        return null;
    }

    @Override
    public Flight getId(Long id) {
        List<Flight> flightList = fileUtil.ReadToFile();
        for (Flight flight : flightList) {
            if (flight.equals(id)) {
                return flight;
            }
        }
        throw new IllegalArgumentException("Id not found!");
    }

    @Override
    public Collection<Flight> getAll() {
        return (List<Flight>) fileUtil.ReadToFile();
    }

    @Override
    public boolean existsTimeAndDestionation(String destionation, LocalDateTime time) {
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
