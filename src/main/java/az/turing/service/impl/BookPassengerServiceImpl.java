package az.turing.service.impl;

import az.turing.domain.dao.inter.BookPassengerDaoInter;
import az.turing.entity.BookPassenger;
import az.turing.mapper.BookPassengerMapper;
import az.turing.model.BookPassengerDto;
import az.turing.service.inter.BookPassengerService;

import java.util.List;
import java.util.Optional;

public class BookPassengerServiceImpl implements BookPassengerService {
    private final BookPassengerDaoInter bookPassengerDaoInter;
    private final BookPassengerMapper bookPassengerMapper;

    public BookPassengerServiceImpl(BookPassengerDaoInter bookPassengerDaoInter, BookPassengerMapper bookPassengerMapper) {
        this.bookPassengerDaoInter = bookPassengerDaoInter;
        this.bookPassengerMapper = bookPassengerMapper;
    }

    @Override
    public BookPassengerDto create(BookPassengerDto bookPassengerDto) {
        BookPassenger bookPassenger = bookPassengerDaoInter.create(bookPassengerMapper.toEnt(bookPassengerDto));
        return bookPassengerMapper.toDto(bookPassenger);
    }

    @Override
    public BookPassengerDto update(BookPassengerDto bookPassengerDto) {
        BookPassenger bookPassenger = bookPassengerDaoInter.update(bookPassengerMapper.toEnt(bookPassengerDto));
        return bookPassengerMapper.toDto(bookPassenger);
    }

    @Override
    public BookPassengerDto delete(long id) {
        BookPassenger bookPassenger = bookPassengerDaoInter.delete(id);
        return Optional.ofNullable(bookPassengerMapper.toDto(bookPassenger))
                .orElseThrow(() -> new IllegalArgumentException("ID not found!" + id));
    }

    @Override
    public Optional<BookPassengerDto> getBookId(long id) {
        BookPassenger bookPassenger = bookPassengerDaoInter.getId(id);
        return Optional.ofNullable(bookPassenger).map(bookPassengerMapper::toDto);
    }

    @Override
    public List<BookPassengerDto> getAll() {
        return bookPassengerDaoInter.getAll().stream().map(bookPassengerMapper::toDto).toList();
    }
}
