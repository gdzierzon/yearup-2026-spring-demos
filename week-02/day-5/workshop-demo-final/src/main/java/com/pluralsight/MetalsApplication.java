package com.pluralsight;

import java.util.Scanner;

public class MetalsApplication
{
    static Scanner userInput = new Scanner(System.in);
    static Metal[] metals;

    static void main()
    {
        // populate the array of metals
        metals = loadMetals();
        boolean keepGoing = true;

        while(keepGoing)
        {
            System.out.println();
            System.out.println("Welcome to Melting Metals");
            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println(" 1) Display all metals");
            System.out.println(" 2) Search by temperature");
            System.out.println(" 3) Search by value");
            System.out.println(" 4) Search by color");
            System.out.println(" x) Exit");
            System.out.print("Please make a selection: ");
            String selection = userInput.nextLine().trim().toLowerCase();

            switch(selection)
            {
                case "1":
                    printAllMetals();
                    break;
                case "2":
                    searchByTemperature();
                    break;
                case "3":
                    searchByValue();
                    break;
                case "4":
                    searchByColor();
                    break;
                case "x":
                    // user chose to exit
                    keepGoing = false;
                    break;
                default:
                    System.out.println("You have made an invalid selection. Please try again");
                    System.out.println();
                    break;
            }
        }

        System.out.println();
        System.out.println("------------------------------");
        System.out.println("Goodbye - come melt again soon");
        System.out.println("------------------------------");
    }

    private static void printAllMetals()
    {
        System.out.println();
        System.out.println("Print all Metals");
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("Name                 Symbol #    Color           Melt Temp Cost per Pound");
        System.out.println("-------------------- ------ ---- --------------- --------- --------------");
        for (int i = 0; i < metals.length; i++)
        {
            Metal metal = metals[i];
            System.out.printf("%-20s %-6s %-4d %-15s %8d°   $ %10.2f\n"
                    , metal.getName()
                    , metal.getSymbol()
                    , metal.getAtomicNumber()
                    , metal.getColor()
                    , metal.getMeltingPointF()
                    , metal.getCostPerPound());
        }
    }

    private static void searchByTemperature()
    {
        System.out.println();
        System.out.println("Search by Temperature");
        System.out.println("---------------------------------");
        System.out.print("Enter the highest melt temp: ");
        int maxTemp = Integer.parseInt(userInput.nextLine());
        System.out.println();

        System.out.println("Name                 Symbol #    Melt Temp");
        System.out.println("-------------------- ------ ---- ---------");
        for (int i = 0; i < metals.length; i++)
        {
            Metal metal = metals[i];

            // skip metal if too hot
            if(metal.getMeltingPointF() > maxTemp) continue;

            System.out.printf("%-20s %-6s %-4d %8d°\n"
                    , metal.getName()
                    , metal.getSymbol()
                    , metal.getAtomicNumber()
                    , metal.getMeltingPointF());
        }
    }

    private static void searchByValue()
    {
        System.out.println();
        System.out.println("Search by Metal Value");
        System.out.println("---------------------------------");
        System.out.print("Enter the lowest cost per pound: ");
        double minValue = Double.parseDouble(userInput.nextLine());
        System.out.println();

        System.out.println("Name                 Symbol #    Cost per Pound");
        System.out.println("-------------------- ------ ---- --------------");
        for (int i = 0; i < metals.length; i++)
        {
            Metal metal = metals[i];

            // skip metal if too hot
            if(metal.getCostPerPound() < minValue) continue;

            System.out.printf("%-20s %-6s %-4d $ %.2f\n"
                    , metal.getName()
                    , metal.getSymbol()
                    , metal.getAtomicNumber()
                    , metal.getCostPerPound());
        }
    }

    private static void searchByColor()
    {
        System.out.println();
        System.out.println("Search by Color");
        System.out.println("---------------------------------");
        System.out.print("Enter the color of the metal: ");
        String color = userInput.nextLine().trim().toLowerCase();
        System.out.println();

        System.out.println("Name                 Symbol #    color");
        System.out.println("-------------------- ------ ---- --------------");
        for (int i = 0; i < metals.length; i++)
        {
            Metal metal = metals[i];

            // skip metal if too hot
            if(!metal.getColor().startsWith(color)) continue;

            System.out.printf("%-20s %-6s %-4d %s\n"
                    , metal.getName()
                    , metal.getSymbol()
                    , metal.getAtomicNumber()
                    , metal.getColor());
        }
    }

    // helper method to load the array
    static Metal[] loadMetals()
    {

        Metal[] metals = new Metal[] {
               // new Metal("test","ab", 0,10, 100,"white",12.5,"FAKE_METALS","LIQUID",true,false,60,31000,"none"),

                new Metal("Mercury", "Hg", 80, -38, 674, "silvery", 13.53, "TRANSITION_METAL", "LIQUID", true, false, null, 4.00, "thermometers"),
                new Metal("Gallium", "Ga", 31, 86, 3999, "silvery", 5.91, "POST_TRANSITION_METAL", "SOLID", false, false, 100, 120.00, "electronics"),
                new Metal("Cesium", "Cs", 55, 83, 1240, "golden", 1.93, "ALKALI_METAL", "SOLID", true, false, 120, 3000.00, "atomic clocks"),
                new Metal("Rubidium", "Rb", 37, 103, 1274, "silvery", 1.53, "ALKALI_METAL", "SOLID", true, false, 140, 1500.00, "research"),
                new Metal("Potassium", "K", 19, 146, 1382, "silvery", 0.86, "ALKALI_METAL", "SOLID", true, false, 180, 50.00, "fertilizer"),
                new Metal("Sodium", "Na", 11, 208, 1621, "silvery", 0.97, "ALKALI_METAL", "SOLID", true, false, 250, 3.00, "salt production"),
                new Metal("Indium", "In", 49, 314, 3762, "silvery", 7.31, "POST_TRANSITION_METAL", "SOLID", false, false, 350, 120.00, "touchscreens"),
                new Metal("Tin", "Sn", 50, 450, 4716, "silvery", 7.29, "POST_TRANSITION_METAL", "SOLID", false, false, 500, 12.00, "solder"),
                new Metal("Bismuth", "Bi", 83, 520, 2847, "iridescent", 9.78, "POST_TRANSITION_METAL", "SOLID", false, false, 575, 6.00, "alloys"),
                new Metal("Lead", "Pb", 82, 621, 3182, "dull gray", 11.34, "POST_TRANSITION_METAL", "SOLID", true, false, 700, 1.20, "batteries"),
                new Metal("Zinc", "Zn", 30, 787, 1665, "bluish silver", 7.14, "TRANSITION_METAL", "SOLID", false, false, 850, 1.30, "galvanizing"),
                new Metal("Magnesium", "Mg", 12, 1202, 1994, "silvery", 1.74, "ALKALINE_EARTH_METAL", "SOLID", false, false, 1300, 2.50, "alloys"),
                new Metal("Aluminum", "Al", 13, 1221, 4473, "silvery", 2.70, "POST_TRANSITION_METAL", "SOLID", false, false, 1350, 1.10, "cans"),
                new Metal("Silver", "Ag", 47, 1763, 3924, "silver", 10.49, "TRANSITION_METAL", "SOLID", false, false, 1850, 350.00, "jewelry"),
                new Metal("Gold", "Au", 79, 1948, 5379, "gold", 19.32, "TRANSITION_METAL", "SOLID", false, false, 2050, 30000.00, "currency"),
                new Metal("Copper", "Cu", 29, 1984, 4652, "reddish", 8.96, "TRANSITION_METAL", "SOLID", false, false, 2100, 4.20, "wiring"),
                new Metal("Nickel", "Ni", 28, 2651, 4915, "silvery", 8.90, "TRANSITION_METAL", "SOLID", false, true, 2750, 8.50, "alloys"),
                new Metal("Cobalt", "Co", 27, 2723, 5301, "bluish", 8.86, "TRANSITION_METAL", "SOLID", true, true, 2850, 16.00, "magnets"),
                new Metal("Palladium", "Pd", 46, 2831, 5360, "silvery", 12.02, "TRANSITION_METAL", "SOLID", false, false, 2950, 14000.00, "catalysts"),
                new Metal("Titanium", "Ti", 22, 3034, 5949, "gray", 4.51, "TRANSITION_METAL", "SOLID", false, false, 3200, 6.00, "aerospace"),
                new Metal("Platinum", "Pt", 78, 3215, 6917, "silvery", 21.45, "TRANSITION_METAL", "SOLID", false, false, 3350, 14000.00, "jewelry"),
                new Metal("Chromium", "Cr", 24, 3465, 4840, "steel gray", 7.19, "TRANSITION_METAL", "SOLID", true, false, 3600, 5.00, "plating"),
                new Metal("Molybdenum", "Mo", 42, 4753, 8382, "gray", 10.28, "TRANSITION_METAL", "SOLID", false, false, 4900, 22.00, "steel alloys"),
                new Metal("Tungsten", "W", 74, 6192, 10031, "gray", 19.25, "TRANSITION_METAL", "SOLID", false, false, 6300, 35.00, "filaments")

        };

        return metals;
    }
}
