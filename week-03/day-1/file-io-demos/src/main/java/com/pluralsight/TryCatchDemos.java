package com.pluralsight;

import java.util.Scanner;

public class TryCatchDemos
{
    static void main()
    {
        Scanner userInput = new Scanner(System.in);
        String[] quotes = {
                "The only thing we have to fear is fear itself. - Franklin D. Roosevelt",
                "I think, therefore I am. - René Descartes",
                "To be, or not to be, that is the question. - William Shakespeare",
                "That's one small step for man, one giant leap for mankind. - Neil Armstrong",
                "In the beginning God created the heavens and the earth. - Genesis 1:1",
                "The unexamined life is not worth living. - Socrates",
                "Do or do not. There is no try. - Yoda",
                "Stay hungry, stay foolish. - Steve Jobs",
                "Success is not final, failure is not fatal: it is the courage to continue that counts. - Winston Churchill",
                "Be the change that you wish to see in the world. - Mahatma Gandhi"
        };

        try
        {
            // any code that could cause a runtime error goes
            // inside the try block
            System.out.print("Enter a number between 1 and 10 to display the quote: ");
            int number = userInput.nextInt();
//            System.out.print("Enter a number to divide by: ");
//            int number2 = userInput.nextInt();
//
//            int answer = number / number2;

            System.out.println("You chose quote number " + number);
            System.out.println(quotes[number - 1]);
        }
        catch(Exception ex)
        {
            // this block of code will ONLY run
            // if there is an exception
            System.out.println("There was an error - OBVIOUSLY YOUR fault.");
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }
    }
}
