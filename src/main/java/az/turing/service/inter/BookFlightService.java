package az.turing.service.inter;

import az.turing.model.BookFlightDto;

import java.util.List;
import java.util.Optional;

public interface BookFlightService {

    BookFlightDto create(BookFlightDto bookRequestDto);

    BookFlightDto update(BookFlightDto bookRequestDto);

    BookFlightDto delete(long id);

    Optional<BookFlightDto> getBookId(long id);

    List<BookFlightDto> getAll();
}
