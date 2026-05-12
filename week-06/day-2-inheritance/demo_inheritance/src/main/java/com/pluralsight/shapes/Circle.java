package com.pluralsight.shapes;

public class Circle extends Square
{

    public  Circle(double radius)
    {
        super(radius * 2);
    }

    public double getDiameter()
    {
        return super.getWidth();
    }

    public double getRadius()
    {
        return getDiameter() / 2;
    }

    @Override
    public double getArea()
    {
        // area of a circle = PI * r (squared)
//        return Math.PI * getRadius() * getRadius();
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double getPerimeter()
    {
        // perimeter = 2 * PI * r
//        return Math.PI * 2 * getRadius();
        return Math.PI * getDiameter();
    }

}
