package az.turing.service.impl;

import az.turing.domain.dao.inter.BookFlightDaoInter;
import az.turing.entity.BookFlight;
import az.turing.exception.AlreadyException;
import az.turing.mapper.BookFlightMapper;
import az.turing.model.BookFlightDto;
import az.turing.service.inter.BookFlightService;

import java.util.List;
import java.util.Optional;

public class BookFlightServiceImpl implements BookFlightService {
    private final BookFlightDaoInter bookFlightDaoInter;
    private final BookFlightMapper bookFlightMapper;

    public BookFlightServiceImpl(BookFlightDaoInter bookFlightDaoInter, BookFlightMapper bookFlightMapper) {
        this.bookFlightDaoInter = bookFlightDaoInter;
        this.bookFlightMapper = bookFlightMapper;
    }

    @Override
    public BookFlightDto create(BookFlightDto bookFlightDto) {
        if (bookFlightDaoInter.existsByFlightId(bookFlightDto.getFlightId())) {
            throw new AlreadyException("Flight already exists!");
        }
        BookFlight bookFlight = bookFlightDaoInter.create(bookFlightMapper.toEnt(bookFlightDto));
        return bookFlightMapper.toDto(bookFlight);
    }

    @Override
    public BookFlightDto update(BookFlightDto bookFlightDto) {
        BookFlight bookFlight = bookFlightDaoInter.update(bookFlightMapper.toEnt(bookFlightDto));
        return bookFlightMapper.toDto(bookFlight);
    }

    @Override
    public BookFlightDto delete(long id) {
        BookFlight bookFlight = bookFlightDaoInter.delete(id);
        return Optional.ofNullable(bookFlight).stream().map(bookFlightMapper::toDto)
                .findAny().orElseThrow(() -> new AlreadyException("Id not found!"));
    }

    @Override
    public Optional<BookFlightDto> getBookId(long id) {
        BookFlight bookFlight = bookFlightDaoInter.getId(id);
        return Optional.ofNullable(bookFlightMapper.toDto(bookFlight));
    }

    @Override
    public List<BookFlightDto> getAll() {
        return bookFlightDaoInter.getAll().stream().map(bookFlightMapper::toDto).toList();
    }
}
