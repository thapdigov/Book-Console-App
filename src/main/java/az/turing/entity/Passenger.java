package az.turing.entity;

import java.util.Objects;

public class Passenger {
    private Integer passengerId;
    private String passengerName;
    private String passengerSurname;

    public Passenger(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passengerId.equals(passenger.passengerId) && passengerName.equals(passenger.passengerName) && passengerSurname.equals(passenger.passengerSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, passengerName, passengerSurname);
    }
}
