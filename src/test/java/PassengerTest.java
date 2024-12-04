import az.turing.domain.dao.impl.memory.PassengerInMemory;
import az.turing.entity.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerTest {
    private PassengerInMemory passengerInMemory;

    @BeforeEach
    public void create() {
        passengerInMemory = new PassengerInMemory();
    }

    @Test
    public void testCreate() {
        Passenger p = new Passenger(5L, "Sanan", "Tapdigov");
        Passenger result = passengerInMemory.create(p);
        assertEquals("Sanan Tapdigov", passengerInMemory.passengerMap.get("5L"));

    }

}
