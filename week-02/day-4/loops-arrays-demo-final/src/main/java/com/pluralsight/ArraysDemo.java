package com.pluralsight;


import java.util.Arrays;

public class ArraysDemo
{
    static void main()
    {
//        int[] numbers = new  int[4];
        int[] numbers = { 4, 12, 31, 2, 98, 13, 21, 57, 15, 17};


        System.out.println("Before sort");
        findNumber(numbers, 13);
        displayLastValue(numbers);

        Arrays.sort(numbers);

        System.out.println();
        System.out.println("After sort");
        displayLastValue(numbers);
        findNumber(numbers, 13);



    }

    static void displayLastValue(int[] numbers)
    {
        int lastIndex = numbers.length - 1;
        System.out.println("Last Number: " + numbers[lastIndex]);
    }

    static void findNumber(int[] numbers, int searchNumber)
    {
        System.out.println("Searching for number: " + searchNumber);

        int position = Arrays.binarySearch(numbers, searchNumber);
        System.out.println("Binary Search Result: " + position);

        for(int i = 0;
            i < numbers.length;
            i++)
        {
            boolean isMatch = numbers[i] == searchNumber;
            if(isMatch)
            {
                System.out.println(i + ": " + numbers[i] + " - Match? " + isMatch);
                break;
            }
        }
    }
}
