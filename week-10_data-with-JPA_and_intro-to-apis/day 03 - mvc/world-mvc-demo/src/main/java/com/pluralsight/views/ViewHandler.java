package com.pluralsight.views;

public interface ViewHandler<T>
{
    void display(T model);

    String getInput();
}
