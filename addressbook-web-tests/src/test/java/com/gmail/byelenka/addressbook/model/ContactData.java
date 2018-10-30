package com.gmail.byelenka.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String email;
    private final String homenumber;
    private String group;

    public ContactData(String firstname, String lastname, String address, String email, String homenumber, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.homenumber = homenumber;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public String getGroup() {
        return group;
    }
}
