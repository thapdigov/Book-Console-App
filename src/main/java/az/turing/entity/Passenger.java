package az.turing.entity;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long passengerId;
    private String passengerName;
    private String passengerSurname;

    public Passenger(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Passenger(Long passengerId, String passengerName, String passengerSurname) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
    }

    public Passenger(String name, String surName) {
        this.passengerName = name;
        this.passengerSurname = surName;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
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

    @Override
    public String toString() {
        return "passengerId=" + passengerId + ",name=" + passengerName + ",surname=" + passengerSurname;
    }
}
