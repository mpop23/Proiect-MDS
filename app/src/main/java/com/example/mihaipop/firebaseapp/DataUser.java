package com.example.mihaipop.firebaseapp;

/**
 * Created by mihaipop on 06/05/2017.
 */


public  class DataUser {

    private String firstName;
    private String lastName;
    private String phone;
    private String country;
    private String privat;

    public DataUser(String firstName, String lastName, String phone, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
        privat="Nu";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getPrivat() {
        return privat;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}