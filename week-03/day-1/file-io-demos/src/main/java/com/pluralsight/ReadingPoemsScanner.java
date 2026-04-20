package com.pluralsight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadingPoemsScanner
{
    static void main()
    {
        try
        {
            // 1) open the file (this LOCKS the file)
            FileReader fileReader = new FileReader("mary_had_a_little_lamb.txt");
            Scanner reader = new Scanner(fileReader);

            while(reader.hasNext())
            {
                // 2) read the contents of the file
                String line = reader.nextLine();

                // 2a) do something with what you read
                System.out.println(line);
            }

            // 3) close the file
            reader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Mary and her lamb are lost.");
        }

    }
}
