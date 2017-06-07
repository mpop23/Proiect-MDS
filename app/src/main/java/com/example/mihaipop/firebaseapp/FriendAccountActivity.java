package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.List;

public class FriendAccountActivity extends AppCompatActivity {

        private Intent myIntent;
        private String myId;
        private String friendId;
        private Firebase mFirebase;
        static private String privat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_account);

        myIntent = getIntent();
        myId = myIntent.getStringExtra("myId"); // will return "myId"
        friendId = myIntent.getStringExtra("friendId"); // will return "friendId"
        mFirebase= new Firebase(getApplicationContext());
        mFirebase.snapShot(friendId,this);

    }

    public void toast(String text) {
        Toast mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
        mToast.show();
    }

    public void test(DataSnapshot dataSnapshot){

        GenericTypeIndicator<List<String>> gti = new GenericTypeIndicator<List<String>>() {};
        privat = dataSnapshot.child(friendId).child("privat").getValue(String.class);
        toast(privat);

    }
}
