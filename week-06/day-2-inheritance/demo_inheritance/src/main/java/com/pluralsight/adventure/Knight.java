package com.pluralsight.adventure;

public class Knight extends Character
{
    int armour;

    public Knight(String name, int health, int level, int experience, int armour)
    {
        super(name, health, level, experience,2, armour * 2);

        this.armour = armour;
    }

    public void addArmour()
    {
        armour++;
        super.setDefenseMultiplier(armour * 2);
    }

    @Override
    public void levelUp()
    {
        // increase the attackMultiplier
        addArmour();
        super.increaseAttackMultiplier();
        super.levelUp();
    }

    @Override
    public void specialAbility()
    {
        System.out.println(getName() + " is a knight with " + armour + " plates and has a defense level of " + getDefenseMultiplier());
    }
}
