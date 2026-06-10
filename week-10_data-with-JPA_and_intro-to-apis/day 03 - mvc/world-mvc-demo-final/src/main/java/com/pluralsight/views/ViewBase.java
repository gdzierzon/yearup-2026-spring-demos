package com.pluralsight.views;

import com.pluralsight.models.AppRequest;

import java.util.Scanner;

public abstract class ViewBase<T> implements ViewHandler<T>
{
    protected static Scanner scanner = new Scanner(System.in);

    protected AppRequest request;

    public ViewBase(AppRequest request)
    {
        this.request = request;
    }

    public AppRequest getRequest()
    {
        return request;
    }
}
