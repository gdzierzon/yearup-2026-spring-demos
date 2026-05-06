package com.pluralsight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest
{

    @Test
    public void accelerate_should_increaseSpeed()
    {
        // arrange
        // setup the object under test
        Car car = new Car("Volkswagen", "Passat");

        // act
        // do the thing we are testing - ONE ACTION ONLY
        car.accelerate(140);

        // assert
        // compare the actual speed to the expected speed
        assertEquals(140, car.getSpeed(), "because I accelerated to 140 mph");

    }

    @Test
    public void accelerate_should_capAt150()
    {
        // arrange
        Car car = new Car("Volkswagen", "Passat");

        // act
        car.accelerate(250);

        // assert
        assertEquals(150, car.getSpeed(), "because I tried to accelerate to 250, and should have stopped at 150");

    }

}