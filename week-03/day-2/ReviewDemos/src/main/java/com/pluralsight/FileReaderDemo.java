package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;


public class FileReaderDemo
{
    public static void main(String[] args)
    {
        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try
        {
            fileReader = new FileReader("names.txt");
            bufferedReader = new BufferedReader(fileReader);

            String name = bufferedReader.readLine();
            while(name != null)
            {
                System.out.println(name);

                name = bufferedReader.readLine();
            }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        finally
        {
            // clean up code
            if(bufferedReader != null)
            {
                try{
                    bufferedReader.close();
                }catch(Exception ex){
                    //ignore
                }
            }
        }
    }
}
