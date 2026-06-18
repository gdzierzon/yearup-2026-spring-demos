package com.pluralsight.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{
    private Map<String, Object> messages = new HashMap<>();
    private int status;

    public void addMessage(String key, Object value)
    {
        messages.put(key, value);
    }

    public static ErrorResponse get500()
    {
        var error = new ErrorResponse();
        error.setStatus(500);
        error.addMessage("Error", "Internal Server Error");
        error.addMessage("Message", "There was an error on our side, we are working on it");

        return error;
    }

    public static ErrorResponse get404()
    {
        var error = new ErrorResponse();
        error.setStatus(404);
        error.addMessage("Error", "Not Found");

        return error;
    }

    public static ErrorResponse get400()
    {
        var error = new ErrorResponse();
        error.setStatus(400);
        error.addMessage("Error", "Bad Request");

        return error;
    }
}
