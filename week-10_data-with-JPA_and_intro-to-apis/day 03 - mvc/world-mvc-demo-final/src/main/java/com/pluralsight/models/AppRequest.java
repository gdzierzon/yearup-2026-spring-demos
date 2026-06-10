package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class AppRequest
{
    private String controller = "";
    private String action = "";
    private List<String> inputParameters = new ArrayList<>();

    public void addParameter(String input)
    {
        inputParameters.add(input);
    }

    public AppRequest(String controller, String action)
    {
        this.controller = controller;
        this.action = action;
    }

    public String getController()
    {
        return controller;
    }

    public void setController(String controller)
    {
        this.controller = controller;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public List<String> getInputParameters()
    {
        return inputParameters;
    }

    public void setInputParameters(List<String> inputParameters)
    {
        this.inputParameters = inputParameters;
    }
}

