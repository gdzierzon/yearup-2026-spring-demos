package com.pluralsight;

import com.pluralsight.io.MetalsFileManager;
import com.pluralsight.models.Metal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{

    static List<Metal> metals;
    static List<String> names = Arrays.asList("Emily", "Lucas", "Sophia", "Edward", "Mason", "Olivia", "Ethan", "Isabella", "Liam", "Charlotte", "Benjamin");
    static List<Integer> numbers = Arrays.asList(new Integer[]{15, 3, 9 ,56 ,21 ,7 ,58 ,13});

    static Scanner scanner = new Scanner(System.in);

    static void main()
    {
        // setup
        metals = MetalsFileManager.loadMetals();

    }

    public static Metal findMetalByName(String name)
    {
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
        for(Metal metal : metals)
        {
            if(metal.getAtomicNumber() == id)
            {
                return metal;
            }
        }
        return null;
    }


    public static List<String> searchNameByFirstLetter(String letter)
    {
        letter = letter.toLowerCase();

        List<String> result = new ArrayList<>();

        for(String name: names)
        {
            if(name.toLowerCase().startsWith(letter))
            {
                result.add(name);
            }
        }

        return result;

    }

    public static int sumNumbers()
    {
        int sum = 0;
        for (int number : numbers)
        {
            sum += number;
        }

        return sum;
    }

    public static int biggestNumber()
    {
        int max = numbers.getFirst();
        for(int number: numbers)
        {
            if(number > max) max = number;
        }

        return max;

    }

    public static int smallestNumber()
    {
        int min = numbers.getFirst();
        for(int number: numbers)
        {
            if(number < min) min = number;
        }

        return min;

    }


}
