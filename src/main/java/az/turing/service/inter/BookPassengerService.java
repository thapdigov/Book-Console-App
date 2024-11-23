package az.turing.service.inter;

import az.turing.model.BookPassengerDto;

import java.util.List;
import java.util.Optional;

public interface BookPassengerService {
    BookPassengerDto create(BookPassengerDto bookPassengerDto);

    BookPassengerDto update(BookPassengerDto bookPassengerDto);

    BookPassengerDto delete(long id);

    Optional<BookPassengerDto> getBookId(long id);

    List<BookPassengerDto> getAll();
}
