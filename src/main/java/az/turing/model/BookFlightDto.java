package az.turing.model;

public class BookFlightDto {
    private long flightId;
    private boolean isActive;

    public BookFlightDto() {
    }

    public BookFlightDto(long flightId, boolean isActive) {
        this.flightId = flightId;
        this.isActive = isActive;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "BookDto -- " +
                "flightId=" + flightId + ", isActive=" + isActive;
    }
}
