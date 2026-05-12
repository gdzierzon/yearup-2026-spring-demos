package com.pluralsight.adventure;

public class Archer extends Character
{
    private int arrows;

    public Archer(String name, int health, int level, int experience, int arrows)
    {
        super(name, health, level, experience);

        this.arrows = arrows;
    }

    // new methods that differentiate the archer from all other characters
    public void addArrow()
    {
        arrows++;
        System.out.println(getName() + " picked up an arrow and now has " + arrows + " arrows.");
    }

    @Override
    public void attack(Character target)
    {
        if(isDefeated())
        {
            System.out.println(getName() + " is dead and cannot attack.");
        }
        else if(arrows <= 0)
        {
            System.out.println(getName() + " is out of arrows and cannot attack.");
        }

        arrows--;
        int damage = attackDamage * 3 * getLevel();
        target.takeDamage(damage);
    }
}
