package az.turing.mapper;

import az.turing.entity.BookPassenger;
import az.turing.model.BookPassengerDto;

public class BookPassengerMapper implements EntityMapper<BookPassenger, BookPassengerDto> {
    @Override
    public BookPassenger toEnt(BookPassengerDto bookPassengerDto) {
        return new BookPassenger(bookPassengerDto.getBookId(), bookPassengerDto.getPassengerId());
    }

    @Override
    public BookPassengerDto toDto(BookPassenger bookPassenger) {
        return new BookPassengerDto(bookPassenger.getBookId(), bookPassenger.getPassengerId());
    }

    @Override
    public <R> R toResponse(BookPassenger bookPassenger) {
        return null;
    }
}
