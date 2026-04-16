package com.pluralsight;

public class Demo
{
    static void main()
    {
        add(5.0, 6.5);
    }

    // The Signature of a function
    // part 1 : return type: void OR some other datatype
    // part 2 : name of the function
    // part 3 : any input parameters (variables) - OPTIONAL
    static int add(int a, int b)
    {
        int answer = a + b;
        return answer;
    }

    static double add(double a, double b)
    {
        return a + b;
    }
}
