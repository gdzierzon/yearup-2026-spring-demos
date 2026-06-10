package com.pluralsight.views;

import java.util.Scanner;

public class UserInputView
{
    private static Scanner scanner = new Scanner(System.in);

    public static String promptForString(String message)
    {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
