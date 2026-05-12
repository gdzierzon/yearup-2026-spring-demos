package com.pluralsight.shapes;

public class Shapes
{
    public static void main(String[] args)
    {
        Rectangle rectangle = new Rectangle(15, 20);
//        rectangle.setHeight(15);
//        rectangle.setWidth(20);

        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

        System.out.println();
        Square square = new Square(10);
//        square.setHeight(10);
//        square.setWidth(15);

        System.out.println("Square area: " + square.getArea());
        System.out.println("Square perimeter: " + square.getPerimeter());

        System.out.println();
        Circle circle = new Circle(5);
        System.out.println("Circle radius: " + circle.getRadius());
        System.out.println("Circle diameter: " + circle.getDiameter());
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());
    }
}
