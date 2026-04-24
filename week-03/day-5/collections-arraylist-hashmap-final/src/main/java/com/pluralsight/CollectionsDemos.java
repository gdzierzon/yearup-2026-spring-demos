package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CollectionsDemos
{
    static ArrayList<Metal> metals;
    static HashMap<String, Metal> metalMapByName = new HashMap<>();
    static HashMap<Integer, Metal> metalMapByAtomicNumber = new HashMap<>();

    static HashMap<Metal, Integer> cart = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    static void main()
    {
        // main should perform setup tasks
        // and launch the application

        // setup
        metals = loadMetals();

        // start
        displayHomeScreen();
    }

    public static void displayHomeScreen()
    {
        while (true)
        {
            System.out.println();
            System.out.println("What do you want to do? ");
            System.out.println("1) search by name");
            System.out.println("2) search by atomic number");
            System.out.println("3) check out");
            System.out.println("x) exit");
            System.out.print("Make a choice: ");
            String choice = scanner.nextLine().strip().toLowerCase();

            Metal metal;

            switch (choice)
            {
                case "1":
                    System.out.print("Enter a metal name to search for: ");
                    String userInput = scanner.nextLine().strip();

                    metal = findMetalByName(userInput);
                    System.out.printf("%s boils at %d\n", metal.getName(), metal.getBoilingTemperature());
                    break;
                case "2":
                    System.out.print("Enter a metal name to search for: ");
                    int id = Integer.parseInt(scanner.nextLine().strip());

                    metal = findMetalByAtomicNumber(id);
                    System.out.printf("%s boils at %d\n", metal.getName(), metal.getBoilingTemperature());
                    break;
                case "3":
                    System.out.println();
                    System.out.println("Enjoy your metals!!!");
                    cart.clear();
                    continue;
                case "x":
                    System.out.println("goodbye");
                    return;
                default:
                    System.out.println("try again");
                    continue;

            }

            if(cart.containsKey(metal))
            {
                // if we already have the metal in our cart
                // udate the quantity
                int quantity = cart.get(metal);
                cart.put(metal, quantity + 1);
            }
            else
            {
                // if the metal is NOT in our cart
                // put 1 in
                cart.put(metal, 1);
            }

            System.out.println();
            System.out.println();
            System.out.println("The Cart");
            System.out.println("----------------");
            for(Map.Entry<Metal, Integer> row : cart.entrySet())
            {
                Metal lineItem = row.getKey();
                int quantity = row.getValue();
                System.out.println(lineItem.getName() + ": " + quantity);
            }
        }






    }

    public static Metal findMetalByName(String name)
    {
//        return metalMapByName.get(name.toLowerCase());

        for(Metal metal : metals)
        {
            if(metal.getName().toLowerCase().contains(name.toLowerCase()))
            {
                return metal;
            }
        }
        return null;
    }

    public static Metal findMetalByAtomicNumber(int id)
    {
        return metalMapByAtomicNumber.get(id);
    }

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
                metalMapByName.put(name.toLowerCase(), metal);
                metalMapByAtomicNumber.put(atomicNumber, metal);

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
