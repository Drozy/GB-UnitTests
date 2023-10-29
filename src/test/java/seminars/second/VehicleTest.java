package seminars.second;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleTest {

    static Car car;
    static Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Chevrolet", "Corvette C2", 1964);
        motorcycle = new Motorcycle("Suzuki ", "GS750", 1978);
    }

    @Test
    void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testMotorcycleIsInstanceOfVehicle() {
        assertTrue(motorcycle instanceof Vehicle);
    }

    @Test
    void checkCarNumWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void checkMotorcycleNumWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void checkCarSpeedWhenDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void checkMotorcycleSpeedWhenDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void checkCarSpeedWhenPark() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void checkMotorcycleSpeedWhenPark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }


}