package az.turing.controller;

import az.turing.model.BookFlightDto;
import az.turing.service.inter.BookFlightService;

import java.util.List;
import java.util.Optional;

public class BookFlightController {

    private final BookFlightService bookFlightService;

    public BookFlightController(BookFlightService bookFlightService) {
        this.bookFlightService = bookFlightService;
    }

    public BookFlightDto create(BookFlightDto bookFlightDto) {
        return bookFlightService.create(bookFlightDto);
    }

    public BookFlightDto update(BookFlightDto bookFlightDto) {
        return bookFlightService.update(bookFlightDto);
    }

    public BookFlightDto delete(long id) {
        return bookFlightService.delete(id);
    }

    public Optional<BookFlightDto> getId(long id) {
        return bookFlightService.getBookId(id);
    }

    public List<BookFlightDto> getAll() {
        return bookFlightService.getAll();
    }


}
