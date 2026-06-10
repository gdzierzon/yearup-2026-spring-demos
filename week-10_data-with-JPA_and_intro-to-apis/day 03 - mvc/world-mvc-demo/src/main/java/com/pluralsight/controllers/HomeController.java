package com.pluralsight.controllers;

import com.pluralsight.models.ControllerResponse;
import com.pluralsight.views.HomeView;

import javax.lang.model.type.NullType;

public class HomeController
{

    public ControllerResponse<String> getHomePage()
    {
        return  new ControllerResponse<>(new HomeView(), null);
    }
}
