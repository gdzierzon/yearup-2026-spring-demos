package com.pluralsight.application;

import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfacesApplication
{
    public void run()
    {
        List<Movable> movables = new LinkedList<>();

        movables.add(new RobotVacuum());
        movables.add(new Robot("Fido"));
        movables.add(new Robot("Spot"));

        for(Movable mover: movables)
        {
            moveAround(mover);
            System.out.println();
        }

        RobotVacuum robot = new RobotVacuum();
        robot.print();

    }

    public void moveAround(Movable mover)
    {
        mover.move(10,15);
        mover.move(new Point(25,12));
        mover.goHome();
    }


}
