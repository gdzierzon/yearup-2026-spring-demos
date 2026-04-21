package com.pluralsight;

import java.util.Arrays;

public class ArrayDemo
{
    static void main()
    {
        int[] nums = {1, 3, 5, 9, 1, 45};

        int lowest = findSmallestNumber(nums);
        System.out.println(lowest);
    }

    public static int findSmallest(int[] numbers)
    {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public static int findSmallestNumber(int[] numbers)
    {
        // setup
        int smallest = Integer.MAX_VALUE;

        // logic
        // loop
        for(int i = 0; i< numbers.length; i++)
        {
            int number = numbers[i];
            if(number < smallest) {
                // update the smallest number
                smallest = number;
            }
        }

        // final result
        return smallest;
    }
}
