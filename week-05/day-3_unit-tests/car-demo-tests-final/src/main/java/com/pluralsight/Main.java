package com.pluralsight;

public class Main
{
    static void main()
    {
        // launch the application
        Car car = new Car("Ford","F350");

        car.accelerate(20);

        System.out.println(car.getModel() + " is going " + car.getSpeed() + " mph");


    }
}
