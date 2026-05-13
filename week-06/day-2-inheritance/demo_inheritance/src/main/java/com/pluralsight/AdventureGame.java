package com.pluralsight;

import com.pluralsight.adventure.Archer;
import com.pluralsight.adventure.Character;
import com.pluralsight.adventure.Knight;

public class AdventureGame
{
    public static void main(String[] args)
    {
        Character character = new Character("Character", 50,1,100);
        Archer archer = new Archer("Archer", 50, 1, 100, 10);
        Knight knight = new Knight("Knight", 50, 1, 100, 2);

        System.out.println();

        character.specialAbility();
        archer.specialAbility();
        knight.specialAbility();

        System.out.println();

        archer.attack(character);
        System.out.println();

        character.attack(archer);
        character.attack(archer);
        System.out.println();

        archer.addArrow();
        archer.addArrow();

        archer.levelUp();
        System.out.println();

        archer.attack(knight);
        System.out.println();

        knight.attack(archer);
        System.out.println();


    }
}
