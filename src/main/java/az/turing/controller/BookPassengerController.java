package az.turing.controller;

import az.turing.model.BookPassengerDto;
import az.turing.service.inter.BookPassengerService;

import java.util.List;
import java.util.Optional;

public class BookPassengerController {
    private final BookPassengerService bookPassengerService;

    public BookPassengerController(BookPassengerService bookPassengerService) {
        this.bookPassengerService = bookPassengerService;

    }

    public BookPassengerDto create(BookPassengerDto bookPassengerDto) {
        return bookPassengerService.create(bookPassengerDto);
    }

    public BookPassengerDto update(BookPassengerDto bookPassengerDto) {
        return bookPassengerService.update(bookPassengerDto);
    }

    public BookPassengerDto delete(long id) {
        return bookPassengerService.delete(id);
    }

    public Optional<BookPassengerDto> getId(long id) {
        return bookPassengerService.getBookId(id);
    }

    public List<BookPassengerDto> getAll() {
        return bookPassengerService.getAll();
    }
}
