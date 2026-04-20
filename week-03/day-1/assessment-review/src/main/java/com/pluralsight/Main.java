package com.pluralsight;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static void main() throws IOException
    {

    }

    static void loopDemo1()
    {
        int answer = 0;

        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                answer = answer + i;
            }
        }

        // what is being printed
        System.out.println(answer);
    }
}
