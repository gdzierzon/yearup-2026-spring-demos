package com.pluralsight.io;

import com.pluralsight.Metal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MetalsFileManager
{
    public static ArrayList<Metal> loadMetals()
    {
        // create the ArrayList
        ArrayList<Metal> metals = new ArrayList<>();


        // try with resources
        try (
                FileReader fileReader = new FileReader("data/metals.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {


            // this get the first line - which is the header
            String line = bufferedReader.readLine();
            // this gets the next line - which is the first line of data
            line = bufferedReader.readLine();
            while(line != null)
            {
                // split the line into an array of strings
                String[] fields = line.split("\\|");
                String name = fields[0];
                String symbol = fields[1];
                int atomicNumber = Integer.parseInt(fields[2]);
                int meltingTemp = Integer.parseInt(fields[3]);
                int boilingTemp = Integer.parseInt(fields[4]);
                String color = fields[5];

                // create a Metal object
                Metal metal = new Metal(name, symbol, atomicNumber, meltingTemp,boilingTemp, color);

                metals.add(metal);

                // move to the next line so we don't have an infinite loop
                line = bufferedReader.readLine();
            }

        }
        catch (Exception e)
        {
            System.err.println("There was a problem reading the file: " + e.getMessage());
        }


        // return the ArrayList
        return metals;
    }
}
