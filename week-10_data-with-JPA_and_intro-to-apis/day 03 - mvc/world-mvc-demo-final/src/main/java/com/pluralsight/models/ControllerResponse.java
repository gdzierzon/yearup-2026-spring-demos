package com.pluralsight.models;

import com.pluralsight.views.ViewHandler;

public class ControllerResponse<T>
{
    private ViewHandler<T> view;
    private T model;

    public ControllerResponse(ViewHandler<T> view, T model)
    {
        this.view = view;
        this.model = model;
    }

    public ViewHandler<T> getView()
    {
        return view;
    }

    public void setView(ViewHandler<T> view)
    {
        this.view = view;
    }

    public T getModel()
    {
        return model;
    }

    public void setModel(T model)
    {
        this.model = model;
    }
}
