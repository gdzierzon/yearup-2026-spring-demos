package com.pluralsight.views;

import java.util.Scanner;

public abstract class ViewBase<T> implements ViewHandler<T>
{
    protected static Scanner scanner = new Scanner(System.in);

    protected String input;

    public String getInput()
    {
        return input;
    }
}
