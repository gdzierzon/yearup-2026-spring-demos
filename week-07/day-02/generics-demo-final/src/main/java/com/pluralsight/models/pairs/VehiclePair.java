package com.pluralsight.models.pairs;

import com.pluralsight.models.Vehicle;

public class VehiclePair
{
    private Vehicle left;
    private Vehicle right;

    public VehiclePair(Vehicle left, Vehicle right)
    {
        this.left = left;
        this.right = right;
    }

    public Vehicle getLeft()
    {
        return left;
    }

    public Vehicle getRight()
    {
        return right;
    }

    public void swap()
    {
        Vehicle temp = left;
        left = right;
        right = temp;
    }
}
