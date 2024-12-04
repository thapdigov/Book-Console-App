package az.turing.model;

public class BookPassengerDto {
    private Long bookId;
    private Long passengerId;

    public BookPassengerDto(Long bookId, Long passengerId) {
        this.bookId = bookId;
        this.passengerId = passengerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return "BookPassenger{" +
                "bookId=" + bookId +
                ", passengerId=" + passengerId +
                '}';
    }
}
