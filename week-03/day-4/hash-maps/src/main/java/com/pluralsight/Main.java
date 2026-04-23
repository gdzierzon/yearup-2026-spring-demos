package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    static void main()
    {
        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 31);
        months.put("February", 28);
        months.put("March", 31);
        months.put("April", 30);
        months.put("May", 31);
        months.put("June", 30);
        months.put("July", 31);
        months.put("August", 31);
        months.put("September", 30);
        months.put("October", 31);
        months.put("November", 30);
        months.put("December", 31);

        int number = months.get("April");

        for(Map.Entry<String, Integer> month : months.entrySet())
        {
            System.out.println(month.getKey() + " has " + month.getValue() + " days.");
        }
    }
}
