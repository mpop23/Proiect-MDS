package com.example.mihaipop.firebaseapp;

/**
 * Created by mihaipop on 06/05/2017.
 */

public class DataUser {

    private String id;
    private String name;
    private String prenume;
    private String user_name;
    private String password;
    private String privat;

    public DataUser(String id, String name, String prenume, String user_name, String password) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.user_name = user_name;
        this.password = password;
        this.privat="Nu";

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getPrivat() {
        return privat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivat(String privat) {
        this.privat = privat;
    }
}
