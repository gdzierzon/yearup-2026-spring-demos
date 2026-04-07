package com.pluralsight;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static void main()
    {
        Scanner userInput = new Scanner(System.in);

        int decimal; // expect binary of 00111001
        String finalBinary = "";
        Stack<Integer> binary = new Stack<>();

        System.out.print("Enter a whole number: ");
        decimal = userInput.nextInt();

        // get all binary values
        while(decimal > 0)
        {
            int remainder = decimal % 2;
            decimal /= 2;

        //            System.out.print("decimal: " + decimal);
        //            System.out.println(" -> remainder: " + remainder);

            binary.push(remainder);

        }

        // add leading zeros
        int zeros = 0;
        if(binary.size() > 8 && binary.size() < 16)
        {
            zeros = 16 - binary.size();
        }
        else if(binary.size() < 8)
        {
            zeros = 8 - binary.size();
        }

        for(int i = 0; i < zeros; i++)
        {
            binary.push(0);
        }

        // put the binary in a string
        while(binary.size() > 0)
        {
            finalBinary += binary.pop();
        }

        System.out.println("Answer: " + finalBinary);
    }
}
