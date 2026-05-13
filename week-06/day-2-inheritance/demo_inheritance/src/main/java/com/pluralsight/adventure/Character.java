package com.pluralsight.adventure;

public class Character
{
    private static final int attackDamage = 10;
    private int attackMultiplier = 1;
    private int defenseMultiplier = 1;

    private String name;
    private int health;
    private int level;
    private int experience;


    public boolean isDefeated()
    {
        return health <= 0;
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getLevel()
    {
        return level;
    }

    public int getAttackMultiplier()
    {
        return attackMultiplier;
    }

    public int getDefenseMultiplier()
    {
        return defenseMultiplier;
    }

    protected void setDefenseMultiplier(int defenseMultiplier)
    {
        this.defenseMultiplier = defenseMultiplier;
    }

    public int getExperience()
    {
        return experience;
    }

    public int getAttackDamage()
    {
        return attackDamage * attackMultiplier * level;
    }

    public Character(String name, int health, int level, int experience)
    {
        this.name = name;
        this.health = health;
        this.level = level;
        this.experience = experience;
    }

    public Character(String name, int health, int level, int experience, int attackMultiplier, int defenseMultiplier)
    {
        this(name, health, level, experience);

        this.attackMultiplier = attackMultiplier;
        this.defenseMultiplier = defenseMultiplier;
    }

    public void attack(Character target)
    {
        if (isDefeated())
        {
            System.out.println(this.name + " has been defeated and cannot attack another player.");
            return;
        }

        System.out.println(this.name + " attacks " + target.getName() + " with damage amount of " + getAttackDamage());

        target.takeDamage(getAttackDamage()); // Example damage value
    }

    public void takeDamage(int damage)
    {
        // calculate damage with defenseMultiplier, damage must be at least 1
        int actualDamage = damage / defenseMultiplier;
        if(actualDamage < 1) actualDamage = 1;

        System.out.println(getName() + " has " + getHealth() + " health before the attack.");
        System.out.println(getName() + " takes " + actualDamage + " damage");

        this.health -= actualDamage;
        if (isDefeated())
        {
            health = 0;
            System.out.println(this.name + " has been defeated!");
        }
        else
        {
            System.out.println(this.name + " now has " + this.health + " health remaining.");
        }
    }

    public void levelUp()
    {
        if(isDefeated())
        {
            System.out.println(this.name + " has been defeated!");
            return;
        }

        this.level++;
        this.health += 10;
        System.out.println(this.name + " has leveled up to level " + this.level + "!");
        System.out.println(this.name + " has " + this.health + " health remaining.");
        specialAbility();
    }

    public void increaseAttackMultiplier()
    {
        attackMultiplier++;
    }

    public void specialAbility()
    {
        System.out.println(this.name + " is a new adventurer and!");
    }
}
