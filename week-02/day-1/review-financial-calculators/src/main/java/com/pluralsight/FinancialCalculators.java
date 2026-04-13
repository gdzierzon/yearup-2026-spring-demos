package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators
{
    // class variables
    static Scanner userInput = new Scanner(System.in);

    static void main()
    {
        // this should LAUNCH the application - nothing more
        start();
    }

    static void start()
    {
        // display the main screen options
        // get user selection
        int selectedOption = 0;

        while(selectedOption != 99)
        {

            System.out.print("""
                    
                    Financial Calculators
                    
                    What do you want to calculate?
                        1)  Monthly Payment
                        2)  Compound Interest
                        3)  Future Annuity
                        99) Exit
                    """);
            System.out.print("Please make your selection: ");
            selectedOption = userInput.nextInt();
            userInput.nextLine();

            switch (selectedOption)
            {
                case 1:
                    displayMonthlyPaymentCalculator();
                    break;
                case 2:
                case 3:
                    System.out.println("coming soon ");
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }
//
//        if(selectedOption == 1)
//        {
//            displayMonthlyPaymentCalculator();
//        } else if(selectedOption == 2 || selectedOption == 3) {
//            System.out.println("coming soon ");
//        } else {
//            System.out.println("Please select a valid option");
//        }

    }

    static void displayMonthlyPaymentCalculator()
    {
        // get loan information
        double loanAmount, annualInterestRate, monthlyInterstRate, monthlyPayment;
        int loanLentghYears;

        System.out.print("Enter the loan amount: ");
        loanAmount = userInput.nextDouble();

        System.out.print("Enter the annual interest rate:");
        annualInterestRate = userInput.nextDouble();

        System.out.print("Enter the loan length in years:");
        loanLentghYears = userInput.nextInt();
        userInput.nextLine(); // clear the stream buffer

        // calculate the monthly payment
        monthlyPayment = calculateMonthlyPayment(loanAmount,annualInterestRate, loanLentghYears);

        // display the monthly payment
        displayMonthlyPayment(monthlyPayment);
    }

    static double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int loanLengthInYears)
    {
        // convert user input into usable values for the formula
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int totalNumberOfPayments = loanLengthInYears * 12;

        // formula
        double numerator = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalNumberOfPayments);
        double denominator = Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1;

        return loanAmount * (numerator / denominator);
    }

    static void displayMonthlyPayment(double monthlyPayment)
    {
        // display the loan information and the calculated monthly payment
        System.out.println("The monthly payment is " + monthlyPayment);
    }
}
