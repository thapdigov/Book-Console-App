package az.turing.domain.dao.impl.file;

import az.turing.domain.dao.inter.BookFlightDaoInter;
import az.turing.entity.BookFlight;
import az.turing.util.FileUtil;

import java.util.Collection;
import java.util.List;

public class BookFile extends BookFlightDaoInter {
    private final FileUtil<BookFlight> fileUtil;

    public BookFile(FileUtil<BookFlight> fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    public BookFlight create(BookFlight bookFlight) {
        List<BookFlight> list = fileUtil.ReadToFile();
        list.add(bookFlight);
        fileUtil.WriteToFile(list);
        return bookFlight;
    }

    @Override
    public BookFlight delete(Long id) {
        List<BookFlight> list = fileUtil.ReadToFile();
        BookFlight bookFlight = list.stream().filter(book1 -> book1.getBookId().equals(id)).findFirst().orElse(null);
        if (bookFlight != null) {
            list.remove(bookFlight);
            fileUtil.WriteToFile(list);
        }
        return bookFlight;
    }

    @Override
    public BookFlight update(BookFlight bookFlight) {
        List<BookFlight> list = fileUtil.ReadToFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookId().equals(bookFlight.getBookId())) {
                list.set(i, bookFlight);
                fileUtil.WriteToFile(list);
            }
        }
        return bookFlight;
    }

    @Override
    public BookFlight getId(Long id) {
        return fileUtil.ReadToFile().stream().filter(book1 -> book1.getBookId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Collection<BookFlight> getAll() {
        return fileUtil.ReadToFile();
    }

    @Override
    public boolean existsByFlightId(Long id) {
        return fileUtil.ReadToFile().stream().anyMatch(book -> book.getFlightId().equals(id));
    }

    @Override
    public String bookingInfo(BookFlight bookFlight) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Flight: ").append("\n").append(bookFlight.getFlightId().toString()).append("\n");
        return stringBuilder.toString();
    }
}
