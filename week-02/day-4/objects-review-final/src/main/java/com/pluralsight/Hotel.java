package com.pluralsight;

public class Hotel
{
    private String name;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }


    public String findCustomer(String firstName, String lastName)
    {
        // search in the db by first name and last name
        return "";
    }

    public String findCustomer(String firstName, String middleName, String lastName)
    {
        // search in the db by first name, middle name, and last name
        return "";
    }

//    public String findCustomer(String city, String state)
//    {
//        // search in the db by first name and last name
//        return "";
//    }

    public String findCustomer(int id)
    {
        // search in the db by customder id
        return "";
    }

}
