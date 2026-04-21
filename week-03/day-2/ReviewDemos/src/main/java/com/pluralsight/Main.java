package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    static void main()
    {
        int dayOfWeek = 4;
        boolean isWeekend = dayOfWeek == 1 || dayOfWeek == 6;

        if(!isWeekend)
        {
            System.out.println("Let's NOT PARTY");
        }

        try
        {
            FileReader fileReader = new FileReader("test.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();
        }
//        catch(FileNotFoundException ex)
//        {
//            System.out.println("Notify the analyst team that files are missing");
//        }
//        catch(IOException ex)
//        {
//            System.out.println("Stream not in readable state");
//        }
        // catch all
        catch (Exception ex)
        {

        }


    }
}
