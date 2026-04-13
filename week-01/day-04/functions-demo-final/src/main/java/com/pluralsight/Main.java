package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static Scanner scanner = new Scanner(System.in);



    static void main()
    {
        // see the original "main" method at the end of this file

        // call functions to do the work instead of writing all the code here
        printHeader();

        // re-use the new printTeamStats functions so that we can remove duplicate code
        printTeamStats("Georgia", 1, 12, 14, 6, 7);
        printTeamStats("Alabama", 2, 14, 17, 10, 14);
        printTeamStats("Ohio State", 3,21, 10, 14, 7);
        printTeamStats("Clemson", 4,10, 10, 7, 17);

        System.out.println();
        System.out.println("Add another team");
        // create a function that allows the user to add information for a new team
        promptUserForTeamInfo();


    }

    static void promptUserForTeamInfo()
    {
        String teamName;
        int rank, q1, q2, q3, q4;

        System.out.print("Enter the team rank: ");
        rank = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the team name: ");
        teamName = scanner.nextLine();

        System.out.print("Enter 4 quarter scores (q1 q2 q3 q4): ");
        q1 = scanner.nextInt();
        q2 = scanner.nextInt();
        q3 = scanner.nextInt();
        q4 = scanner.nextInt();
        scanner.nextLine();

        printTeamStats(teamName, rank, q1, q2, q3, q4);

    }

    static void printHeader()
    {
//        System.out.printf(" %-2s %-15s %-2s  %-2s  %-2s  %-2s  %s \n","#", "Team Name", "Q1","Q2","Q3","Q4","Final");
//        System.out.printf("%-3s %-15s %-3s %-3s %-3s %-3s %s \n"
//                , "-".repeat(3)
//                , "-".repeat(15)
//                , "-".repeat(3)
//                , "-".repeat(3)
//                , "-".repeat(3)
//                , "-".repeat(3)
//                , "-".repeat(5));


        System.out.println(" #  Team Name       Q1  Q2  Q3  Q4  Final Avg");
        System.out.println("--- --------------- --- --- --- --- ----- ----");
    }

    // DRY - Don't Repeat Yourself
    // static - this is required TODAY because main() is static
    // void - means this function DOES NOT return a value
    // printTeamStats - this is the NAME of the function
    // (inside parenthesis) - these are the input parameters - they create local variables
    //      - this means that any coded that calls this function MUST provide values for these parameters
    static void printTeamStats(String teamName, int rank, int q1, int q2, int q3, int q4)
    {
        int finalScore = calculateFinalScore(q1, q2, q3, q4);
        int averageQuarterScore = calculateAverageQuarterScore(q1, q2, q3, q4);

        System.out.printf(" %-2d %-15s %-2d  %-2d  %-2d  %-2d  %-5d %d\n",rank, teamName, q1, q2,q3,q4,finalScore, averageQuarterScore);

    }

    // int - this function MUST return an int value
    // calculateFinalScore - the name of the function
    // (int q1, int q2, int q3, int q4) - defines the input parameters
    static int calculateFinalScore(int q1, int q2, int q3, int q4)
    {
        return q1 + q2 + q3 + q4;
    }

    static int calculateAverageQuarterScore(int q1, int q2, int q3, int q4)
    {
        int finalScore = calculateFinalScore(q1, q2, q3, q4);
        return finalScore / 4;
    }

    static void origina_main()
    {
        // there is a lot of repeated code in this application
        // we want to minimize how often we re-write the same code

        // declare base variables that will be reused
        String teamName;
        int rank, q1, q2, q3, q4, finalScore;

        /* start repeatable code */
        // Georgia
        teamName = "Georgia";
        rank = 1;
        q1 = 12;
        q2 = 14;
        q3 = 6;
        q4 = 7;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */


        /* start repeatable code */
        // Alabama
        teamName = "Alabama";
        rank = 2;
        q1 = 14;
        q2 = 17;
        q3 = 10;
        q4 = 14;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */


        /* start repeatable code */
        // Ohio State
        teamName = "Ohio State";
        rank = 3;
        q1 = 21;
        q2 = 10;
        q3 = 14;
        q4 = 7;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf("  %2d  %2d  %2d  %2d  %2d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */

        /* Add your code here */
        /* start repeatable code */
        // Ohio State
        teamName = "Clemson";
        rank = 3;
        q1 = 21;
        q2 = 10;
        q3 = 14;
        q4 = 7;
        finalScore = q1 + q2 + q3 + q4;

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
        /* end repeatable code */

    }
}
