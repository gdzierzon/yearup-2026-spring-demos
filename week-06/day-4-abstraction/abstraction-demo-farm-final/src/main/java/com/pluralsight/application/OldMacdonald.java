package com.pluralsight.application;

import com.pluralsight.models.*;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class OldMacdonald
{
    UserInterface userInterface = new UserInterface();

    ArrayList<FarmAnimal> animals = new ArrayList<>();

    public OldMacdonald()
    {
        FarmAnimal animal = new Sheep();

        animals.add(new Cow());
        animals.add(new Chicken());
        animals.add(new Pig());
        animals.add(new Sheep());

        Cow cow = new Cow();
        cow.setEating(true);
        animals.add(cow);

        // can't create a FarmAnimal directly
        //  animals.add(new FarmAnimal("Wolf", "GRRRR!!!"));

    }

    public void run() throws InterruptedException
    {
        userInterface.sayHello();

        while(true)
        {
            int choice = userInterface.getHomeScreenChoice();

            if(choice == 1)
            {
                singSong();
            }
            else if(choice ==2)
            {
                feedAnimals();
            }
            else
            {
                userInterface.sayGoodbye();
                System.exit(0);
            }
        }
    }

    private void feedAnimals()
    {
        for(FarmAnimal animal: animals)
        {
            animal.eat();
        }
    }

    private void singSong() throws InterruptedException
    {
        userInterface.singSongIntro();


        for (FarmAnimal animal: animals)
        {
            userInterface.singVerse(animal);
        }


    }


}
