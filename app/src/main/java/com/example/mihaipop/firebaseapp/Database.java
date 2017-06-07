package com.example.mihaipop.firebaseapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {
    /**
     * Add a new user to the database.
     * @param user the user to be registered.
     */
    public static void registerUser(UserData user) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference().child("users");
        users.push().setValue(user);
    }

}
