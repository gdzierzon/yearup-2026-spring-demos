package com.pluralsight;

public class CarTests
{
    static void main()
    {
        testThatCarSpeedsUp();
    }

    public static void testThatCarSpeedsUp()
    {
        // setup the object to be tested
        Car car = new Car("Volkswagen", "Passat");

        // do the thing we are testing
        car.accelerate(140);

        // compare the actual speed to the expected speed
        System.out.println("Expected Speed: 140");
        System.out.println("Actual Speed: " + car.getSpeed());
        System.out.println(140 == car.getSpeed());
        System.out.println();
    }
}
