package com.example.mihaipop.firebaseapp;

/**
 * Created by mihaipop on 06/05/2017.
 * CHANGES: Changed name to a better one.
 */

public  class UserData {

    private String firstName;
    private String lastName;
    private String phone;
    private String country;
    private String privat;
    private String description;
    private int noFriends;
    private int noQuestion;

    public UserData(){}

    public UserData(String firstName, String lastName, String phone, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
        privat = "Nu";
        description = "";
        noFriends = 0;
        noQuestion = 0;
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

    public String getDescription() {
        return description;
    }

    public int getNoFriends() {
        return noFriends;
    }

    public int getNoQuestion() {
        return noQuestion;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNoFriends(int noFriends) {
        this.noFriends = noFriends;
    }

    public void setPrivat(String privat) {

        this.privat = privat;
    }

    public void setNoQuestion(int noQuestion) {
        this.noQuestion = noQuestion;
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

    public void setDescription(String description) {
        this.description = description;
    }

}