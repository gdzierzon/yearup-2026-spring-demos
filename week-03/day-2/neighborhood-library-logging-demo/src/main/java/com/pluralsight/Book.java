package com.pluralsight;

public class Book
{
    // private variables
    private int id = 0;
    private String isbn = "";
    private String title = "";
    private boolean isCheckedOut = false;
    private String checkedOutTo = "";

    // constructors
    public Book()
    {
    }

    public Book(int id, String isbn, String title)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public Book(int id, String isbn, String title, String checkedOutTo)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = true;
        this.checkedOutTo = checkedOutTo;
    }
    // getters / setters

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isCheckedOut()
    {
        return isCheckedOut;
    }

    public String getCheckedOutTo()
    {
        return checkedOutTo;
    }

    // methods
    // returns true if the book was successfully checked out
    // return false if the book is already checked out to someone else
    public boolean checkOut(String name)
    {
        if(isCheckedOut)
        {
            return false;
        }

        checkedOutTo = name;
        isCheckedOut = true;
        return true;
    }

    public void checkIn()
    {
        isCheckedOut = false;
        checkedOutTo = "";
    }
}
