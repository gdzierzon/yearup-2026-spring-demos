package com.pluralsight.models.pairs.music;

public class Violinist implements Musician
{
    @Override
    public void perform()
    {
        System.out.println("The violinist plays the violin");
    }
}
