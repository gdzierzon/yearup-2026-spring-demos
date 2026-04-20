package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadingPoemsBufferedReader
{
    static void main()
    {
        try
        {
            // 1) open the file (this LOCKS the file)
            FileReader fileReader = new FileReader("mary_had_a_little_lamb.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            // 2) read the FIRST line
            String line = reader.readLine();
            // was there a line to read?
            while(line != null)
            {
                // 2a) do something with what you read
                System.out.println(line);

                // 2) continue to read the next line until
                //    there are no more lines
                line = reader.readLine();
            }

            // 3) close the file
            reader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Mary and her lamb are lost.");
        }
        catch(IOException ex)
        {
            System.out.println("There was a problem reading a line in the file");
        }

    }
}
