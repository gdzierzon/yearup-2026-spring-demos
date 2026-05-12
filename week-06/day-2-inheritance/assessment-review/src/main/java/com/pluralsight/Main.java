package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.FileStore;
import java.util.ArrayList;

public class Main
{
    static void main()
    {
//        tryCatchDemos();
        arrayListDemos();
    }

    public static void tryCatchDemos()
    {

        try
        {
            //  // this code block is to simulate a locked file that cannot be read - will cause
            //  // an IOException later when other code tries to read the file
//            RandomAccessFile file = new RandomAccessFile("numbers.txt", "rw");
//            FileChannel channel = file.getChannel();
//            // Exclusive lock
//            FileLock lock = channel.lock();

            FileReader fileReader = new FileReader("numbers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            double sum = 0;
            String line;
            int errorCount = 0;

            while((line = bufferedReader.readLine()) != null)
            {
                try
                {
                    sum += Double.parseDouble(line);
                }
                catch (Exception e)
                {
                    errorCount++;
                }
            }


            System.out.println("the sum is: " + sum);

            if(errorCount > 0)
            {
                System.out.println("The data file had " + errorCount + " bad lines in it.");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found block");

            System.err.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("The file is locked");
        }
        catch (NumberFormatException e)
        {
            System.err.println(e.getMessage());
            System.out.println("Please make sure that the data file is in the correct format");
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            System.out.println();
            e.printStackTrace();
        }
        finally
        {

        }
    }

    public static void arrayListDemos()
    {
        ArrayList<String> heroes = new ArrayList<>();

        heroes.add("Thor");
        heroes.add("Iron Man");
        heroes.add("Captain America");
        heroes.add("Black Widow");
        heroes.add("Black Panther");
        heroes.add("Thor");

        System.out.println("There are " + heroes.size() + " heroes");
        // this is a Java Stream - the forEach stream function works
        // similar to the for loop below
        heroes.stream().forEach(hero -> System.out.println(hero));
        System.out.println();

//        for(String hero: heroes)
//        {
//            System.out.println(hero);
//        }

        heroes.remove("Thor");

        System.out.println("There are now " + heroes.size() + " heroes");
        heroes.stream().forEach(hero -> System.out.println(hero));
        System.out.println();
    }
}
