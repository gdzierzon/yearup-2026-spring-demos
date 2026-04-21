package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;


public class Main
{
    static void main()
    {
        // variable for READING a file
        FileReader fileReader;
        BufferedReader bufferedReader = null;

        // variables for WRITING to a file
        FileOutputStream fileOutputStream;
        PrintStream printer = null;

        try
        {
            // 1) load the file
            fileReader = new FileReader("metals.csv");
            bufferedReader = new BufferedReader(fileReader);

            // 1b) create the new file
            fileOutputStream = new FileOutputStream("MetalInformation.txt");
            printer = new PrintStream(fileOutputStream);

            // 2) read all lines in the file
            String line = bufferedReader.readLine();
            // need to skip the header row
            line = bufferedReader.readLine();

            while(line != null)
            {
                // convert each line into a Metal
                String[] parts = line.split(Pattern.quote("|"));

                String name = parts[0];
                String symbol = parts[1];
                int atomicNumber = Integer.parseInt(parts[2]);
                double meltingPoint = Double.parseDouble(parts[3]);
                double boilingPoint = Double.parseDouble(parts[4]);
                String color = parts[5];

                Metal metal = new Metal(name, symbol, atomicNumber, meltingPoint, boilingPoint,color);

                // write to some output
                // write to file
                printer.printf("%-15s %-20s %-10.2f %-7.2f \n"
                        , metal.getName()
                        , metal.getColor()
                        , metal.getMeltingPoint()
                        , metal.getPouringTemp());

//                // writing to the screen
//                System.out.printf("%-15s %-20s %-10.2f %-7.2f \n"
//                        , metal.getName()
//                        , metal.getColor()
//                        , metal.getMeltingPoint()
//                        , metal.getPouringTemp());

                line = bufferedReader.readLine();
            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        finally
        {
            // 3) close the file
            try
            {
                if(bufferedReader != null) bufferedReader.close();
                if(printer != null) printer.close();
            }
            catch(Exception ex){}
        }

    }

}
