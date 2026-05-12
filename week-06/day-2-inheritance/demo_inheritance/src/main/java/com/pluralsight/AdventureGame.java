package com.pluralsight;

import com.pluralsight.adventure.Archer;
import com.pluralsight.adventure.Character;

public class AdventureGame
{
    public static void main(String[] args)
    {
        Archer hero = new Archer("Hero", 50, 1, 100, 10);
        Character villain = new Character("Villain", 50,1,100);

        System.out.println();

        hero.attack(villain);
        System.out.println();

        villain.attack(hero);
        villain.attack(hero);
        System.out.println();

        hero.addArrow();
        hero.addArrow();
        hero.attack(villain);
        System.out.println();

        villain.attack(hero);
        villain.attack(hero);
        villain.attack(hero);
        System.out.println();

        hero.levelUp();
        System.out.println();

        hero.attack(villain);
        System.out.println();


    }
}
