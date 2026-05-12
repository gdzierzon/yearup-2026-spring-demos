package com.pluralsight;

import com.pluralsight.adventure.Character;

public class AdventureGame
{
    public static void main(String[] args)
    {
        Character hero = new Character("Carla", 50, 1, 100);
        Character villain = new Character("Joseph", 50,1,100);

        villain.attack(hero);
        System.out.println();

        hero.levelUp();
        System.out.println();

        hero.attack(villain);
        System.out.println();


    }
}
