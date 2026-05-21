package com.pluralsight;

import com.pluralsight.io.MetalsFileManager;

import java.util.*;

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
//
//        List<String> matches = searchNameByFirstLetter("e");
//
//        for (String name: matches)
//        {
//            System.out.println(name);
//        }

        numbers.stream()
                .filter(n -> n % 3 == 0)
                .forEach( n -> System.out.println(n));

        // double the values
        numbers.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);


        int sum = numbers.stream()
                        .mapToInt(n -> n)
                        .sum();
        System.out.println(sum);

        var averageMeltingTemp = metals.stream()
                                        .mapToDouble(m -> m.getMeltingTemperature())
                                        .average()
                                        .orElse(0.0)
                ;

        names.stream()
            .filter(n -> n.length() > 5)
            .map(String::toUpperCase)
            .forEach(System.out::println);


        System.out.println();
        System.out.println("Biggest Number");
        var bigNumber = biggestNumber();
        System.out.println(bigNumber);


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


    public static void printMetalsByColor(String color)
    {
        for(Metal metal : metals)
        {
            if(metal.getColor().equalsIgnoreCase(color))
            {
                System.out.println(metal.getName());
            }
        }
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
        final String searchLetter = letter.toLowerCase();

//        List<String> result = new ArrayList<>();
//
//        for(String name: names)
//        {
//            if(name.toLowerCase().startsWith(letter))
//            {
//                result.add(name);
//            }
//        }

        List<String> result = names.stream() // source
                                    // transformations go here
                                    .filter((name) -> {
                                        // return t/f whether this name should be passed along to the next step
                                        return name.toLowerCase().startsWith(searchLetter);
                                    })
                                    //.filter(name -> includeName(name, searchLetter))
                                    //.filter(name -> name.toLowerCase().startsWith(searchLetter))
                                    .toList(); // destination (I have to collect the items and close the stream)

        return result;

    }

    public static boolean includeName(String name, String letter)
    {
        return name.toLowerCase().startsWith(letter);
    }

    public static int sumNumbers()
    {
//        int sum = 0;
//        for (int number : numbers)
//        {
//            sum += number;
//        }
//
//        return sum;

        return numbers.stream()
                .reduce(0,(sum, n) -> sum += n);
    }

    public static int biggestNumber()
    {
//        // placeholder
//        int max = 0; numbers.getFirst();
//
//        for(int number: numbers)
//        {
//            if(number > max) max = number;
//        }
//
//        return max;

        return numbers.stream()
                        .reduce(0,(max, number) -> max > number ? max : number);

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
