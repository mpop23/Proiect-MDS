package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FriendAccountActivity extends AppCompatActivity {

    private Intent myIntent;
    private String myId;
    private String friendId;
    private Firebase mFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_account);

        myIntent = getIntent();
        myId = myIntent.getStringExtra("myId"); // will return "myId"
        friendId= myIntent.getStringExtra("friendId"); // will return "friendId"

        mFirebase= new Firebase(getApplicationContext());


    }
}
