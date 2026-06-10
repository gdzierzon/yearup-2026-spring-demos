package com.pluralsight.views;

import com.pluralsight.models.AppRequest;

public interface ViewHandler<T>
{
    void display(T model);

    AppRequest getRequest();
}
