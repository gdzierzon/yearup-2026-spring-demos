package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in);
    static Book[] books;

    static void main()
    {
        loadBooks();

        System.out.println();
        String choice = "";

        // loop to display the homescreen until the user chooses to exit
        while(!choice.equalsIgnoreCase("x"))
        {
            System.out.println();
            System.out.println("Neighborhood Library");
            System.out.println();

            System.out.println("Show (A)vailable Books");
            System.out.println("Show (C)hecked Out Books");
            System.out.println("E(x)it");
            System.out.println();

            System.out.print("Make a choice: ");
            choice = userInput.nextLine().strip().toLowerCase();

            switch (choice)
            {
                case "a":
                    showAvailableBooks();
                    break;
                case "c":
                    showCheckedOutBooks();
                    break;
                case "x":
                    break;
                default:
                    System.out.println("Please make a valid selection.");
            }
        }
    }


    private static void showAvailableBooks()
    {

        while(true)
        {
            logAction("SHOW AVAILABLE","");

            System.out.println("Id  Title                                              ISBN");
            System.out.println("--- -------------------------------------------------- --------------------");
            for (int i = 0; i < books.length; i++)
            {
                Book book = books[i];
                if(!book.isCheckedOut())
                {
                    System.out.printf("%-3d %-50s %s\n", book.getId(), book.getTitle(), book.getIsbn());
                }
            }

            System.out.println();

            System.out.println("C) Check out a book");
            System.out.println("X) Back to home screen");
            System.out.println();
            System.out.print("Make a selection: ");
            String choice = userInput.nextLine().strip().toLowerCase();

            switch (choice)
            {
                case "c":
                    checkOutBook();
                    System.out.print("Press ENTER to continue...");
                    userInput.nextLine();
                    break;
                case "x":
                    return;
            }
        }
    }

    private static void showCheckedOutBooks()
    {
        while(true)
        {
            logAction("SHOW CHECKED OUT","");

            // display books
            System.out.println("Id  Title                                              ISBN                 Checked Out To");
            System.out.println("--- -------------------------------------------------- -------------------- --------------");
            for (int i = 0; i < books.length; i++)
            {
                Book book = books[i];
                if(book.isCheckedOut())
                {
                    System.out.printf("%-3d %-50s %-20s %s\n", book.getId(), book.getTitle(), book.getIsbn(), book.getCheckedOutTo());
                }
            }
            System.out.println();

            System.out.println("C) Check in a book");
            System.out.println("X) Back to home screen");
            System.out.println();
            System.out.print("Make a selection: ");
            String choice = userInput.nextLine().strip().toLowerCase();

            switch (choice)
            {
                case "c":
                    checkInBook();
                    System.out.print("Press ENTER to continue...");
                    userInput.nextLine();
                    break;
                case "x":
                    return;
            }
        }

    }

    private static void checkOutBook()
    {
        System.out.println();
        System.out.print("Enter the book id to check out: ");
        int id = Integer.parseInt(userInput.nextLine());
        System.out.print("Enter the customer name: ");
        String name = userInput.nextLine();

        System.out.println();
        Book book = findBook(id);

        // if the user entered an invalid book id
        if(book == null)
        {
            System.out.printf("Book id %d could not be found.\n", id);
            return;
        }

        // check if the book is already checked out
        boolean checkoutSucceeded = book.checkOut(name);
        if(checkoutSucceeded)
        {
            logAction("CHECKOUT", String.format("%s checked out to %s", book.getTitle(), book.getCheckedOutTo()));
            System.out.printf("%s has been successfully checked out to %s. \n", book.getTitle(), book.getCheckedOutTo());
        }
        else
        {
            System.out.printf("%s is already checked out. \n", book.getTitle());
        }
    }

    private static void checkInBook()
    {
        System.out.println();
        System.out.print("Enter the book id to check in: ");
        int id = Integer.parseInt(userInput.nextLine());

        System.out.println();
        Book book = findBook(id);

        // if user entered an invalid book id
        if(book == null)
        {
            System.out.printf("Book id %d could not be found.\n", id);
        }

        logAction("CHECKIN", String.format("%s checked in by %s", book.getTitle(), book.getCheckedOutTo()));
        book.checkIn();
        System.out.printf("%s has been checked in. \n", book.getTitle());
    }


    private static Book findBook(int id)
    {
        for (int i = 0; i < books.length; i++)
        {
            Book book = books[i];
            // stop looping and return the book if I find it
            if(book.getId() == id) return book;
        }

        // the book was not found - return null
        return null;
    }

    private static void loadBooks_old()
    {
        books = new Book[] {
                new Book(1, "978-0-735-21129-2", "Atomic Habits"),
                new Book(2, "978-0-062-31611-0", "The Alchemist"),
                new Book(3, "978-0-553-38016-3", "A Game of Thrones"),
                new Book(4, "978-0-345-33970-6", "The Hobbit"),
                new Book(5, "978-0-441-01359-3", "Dune"),
                new Book(6, "978-0-765-37706-7", "The Name of the Wind", "Jane"),
                new Book(7, "978-0-345-80348-1", "Fifty Shades of Grey"),
                new Book(8, "978-1-501-12803-5", "It Ends with Us"),
                new Book(9, "978-0-143-12774-1", "Thinking, Fast and Slow", "John"),
                new Book(10, "978-0-307-27767-1", "The Road", "Glen"),
                new Book(11, "978-0-547-92822-7", "The Fellowship of the Ring"),
                new Book(12, "978-0-547-92820-3", "The Two Towers"),
                new Book(13, "978-0-547-92819-7", "The Return of the King","Sarah"),
                new Book(14, "978-0-060-85052-4", "Brave New World"),
                new Book(15, "978-0-451-52493-5", "1984"),
                new Book(16, "978-0-385-53785-8", "Ready Player One", "Juan"),
                new Book(17, "978-0-590-35342-7", "Harry Potter and the Sorcerer's Stone", "George"),
                new Book(18, "978-0-439-70818-0", "Harry Potter and the Chamber of Secrets"),
                new Book(19, "978-0-439-13960-1", "Harry Potter and the Prisoner of Azkaban"),
                new Book(20, "978-0-061-12008-4", "To Kill a Mockingbird"),
                new Book(21, "978-1-259-64341-5", "Easy Spanish Step-By-Step"),
                new Book(22, "978-1-444-17739-3", "Complete German","Gregor"),
                new Book(23, "978-1-260-45515-1", "Practice Makes Perfect: French Verb Tenses"),
                new Book(24, "978-0-071-75030-1", "Living Language Japanese"),
                new Book(25, "978-1-138-95012-2", "Colloquial Russian", "Gregor"),
                new Book(26, "978-0-470-89386-9", "The Five Dysfunctions of a Team"),
                new Book(27, "978-1-982-13727-4", "The 7 Habits of Highly Effective People"),
                new Book(28, "978-1-594-63366-9", "The Girl on the Train"),
                new Book(29, "978-0-307-88744-3", "Ready Player Two"),
                new Book(30, "978-0-066-62099-2", "Good to Great")
        };
    }

    private static void loadBooks()
    {
        books = new Book[50];

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try
        {
            fileReader = new FileReader("books.csv");
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine(); // read the header line and ignore it
            int index = 0;
            while (line != null)
            {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String isbn = parts[2];

                // create a new book object and add it to the array
                Book book = new Book(id, isbn, title);
                // add book to array
                books[index] = book;
                index++;

                line = bufferedReader.readLine();
            }
        }
        catch (Exception ex)
        {

        }
        finally
        {

                if(bufferedReader != null)
                {
                    try
                    {
                        bufferedReader.close();
                    }
                    catch (Exception _) {}
                }
        }
    }

    private static void logAction(String action, String message)
    {

        FileOutputStream fileOutputStream = null;
        PrintWriter printWriter = null;

        try
        {
            // when I create a new FileOutputStream, the optional 2nd parameter specifies
            // if I want to open the file for appending
            fileOutputStream = new FileOutputStream("Log.txt",true);
            printWriter = new PrintWriter(fileOutputStream);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);

            printWriter.printf("%s %s: %s\n", timestamp, action, message);

        }catch(Exception ex)
        {

        }
        finally
        {
            if(printWriter != null)
            {
                // PrintWriter doesn't throw an exception if it fails to close, so we don't need to catch it
                printWriter.close();
            }
        }
    }
}
