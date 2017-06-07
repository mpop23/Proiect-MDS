package com.example.mihaipop.firebaseapp;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> friends;


    /**
     * the prefix 'no' has been replaced with the prefix 'nr' for
     * minimizing the confusion with the logical "no" for negation
     * when you see 'noFriends' you think 'no Friends' meaning
     * not a single friend. 'nrFriend' it is more clear that refers to
     * 'number of friends'
     */
    private int nrFriends;
    private int nrQuestion;

    public UserData(){}

    public UserData(String firstName, String lastName, String phone, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
        privat = "Nu";
        description = "";
        nrFriends = 0;
        nrQuestion = 0;
        friends = new ArrayList<>();
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

    public int getNrFriends() {
        return nrFriends;
    }

    public int getNrQuestion() {
        return nrQuestion;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNrFriends(int nrFriends) {
        this.nrFriends = nrFriends;
    }

    public void setPrivat(String privat) {

        this.privat = privat;
    }

    public void setNrQuestion(int nrQuestion) {
        this.nrQuestion = nrQuestion;
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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}