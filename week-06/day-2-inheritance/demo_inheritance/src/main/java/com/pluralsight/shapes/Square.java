package com.pluralsight.shapes;

// 1. to inherit we use the keyword extends
public class Square extends Rectangle
{

    // 3. constructor must pass information to parent constructor
    public Square(double sideLength)
    {
        // calling the super constructor MUST be the first line of code
        super(sideLength, sideLength);

    }

    // 2. add methods that are unique to the child

    // 2a. child can override logic of parent method
    @Override
    public void setWidth(double width)
    {
        // super keyword refers to the parent
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(double height)
    {
        // super keyword refers to the parent
        super.setWidth(height);
        super.setHeight(height);
    }
}
