package az.turing.mapper;

import az.turing.entity.BookFlight;
import az.turing.model.BookFlightDto;

public class BookFlightMapper implements EntityMapper<BookFlight, BookFlightDto> {
    @Override
    public BookFlight toEnt(BookFlightDto bookFlightDto) {
        return new BookFlight(bookFlightDto.getFlightId(), bookFlightDto.isActive());
    }

    @Override
    public BookFlightDto toDto(BookFlight bookFlight) {
        return new BookFlightDto(bookFlight.getFlightId(), bookFlight.isActive());
    }

    @Override
    public <R> R toResponse(BookFlight bookFlight) {
        return null;
    }
}
