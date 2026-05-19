package com.pluralsight.models;

public interface Cleaner
{
    void clean();

    default void print()
    {
        System.out.println("This object can clean");
    }
}
