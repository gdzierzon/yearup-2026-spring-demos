package com.pluralsight.views;

import com.pluralsight.models.AppRequest;

public class CityGetCountryInputView extends ViewBase<String>
{
    public CityGetCountryInputView(AppRequest request)
    {
        super(request);
    }

    @Override
    public void display(String model)
    {
        System.out.println();
        System.out.print("Enter a country name: ");
        String country = scanner.nextLine().trim();

        request.addParameter(country);
    }
}
