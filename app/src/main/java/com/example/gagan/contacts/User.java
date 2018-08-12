package com.example.gagan.contacts;

/**
 * Created by gagan on 20/09/2017.
 */

public class User {
    private String FirstName;
    private String LastName;
    private String Number;
    private String Email;

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getNumber() {
        return Number;
    }

    public String getEmail() {
        return Email;
    }

    public User(String fName, String lName, String Num, String eMail)
    {
        FirstName=fName;
        LastName=lName;
        Number=Num;
        Email=eMail;
    }

}
