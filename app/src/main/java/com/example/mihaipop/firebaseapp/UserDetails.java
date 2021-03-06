package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by mihaipop
 */
public class UserDetails extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView phone;
    private TextView country;
    private DatabaseReference dbUsers;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button buttonAddDetails;
    private String currentUserId;
    private static final String TAG = "UserDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbUsers = FirebaseDatabase.getInstance().getReference("users");
        firstName = (TextView) findViewById(R.id.firstnameD);
        lastName = (TextView)findViewById(R.id.lastnameD);
        phone = (TextView) findViewById(R.id.phoneD);
        country = (TextView) findViewById(R.id.countryD);
        buttonAddDetails = (Button) findViewById(R.id.addDataD);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    currentUserId = user.getUid();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        buttonAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserData();
            }
        });
    }

    public void addUserData() {

        String firstName = this.firstName.getText().toString().trim();
        String lastName = this.lastName.getText().toString().trim();
        String phone = this.phone.getText().toString().trim();
        String country = this.country.getText().toString().trim();

        // validate inputs and then create the UserData object to hold the data

        // validate first name
        if (firstName.length() == 0 || !firstName.toLowerCase().matches("[a-z][a-z]{2,}")) {
            Toast.makeText(getApplicationContext(), "Numele este invalid.", Toast.LENGTH_LONG).show();
            return;
        }

        // validate last name
        if (lastName.length() == 0 || !lastName.toLowerCase().matches("[a-z][a-z]{2,}")) {
            Toast.makeText(getApplicationContext(), "Prenumele este invalid.", Toast.LENGTH_LONG).show();
            return;
        }

        // validate phone
        if (phone.length() == 0 || !phone.matches("[0-9][0-9]{9,}")) {
            Toast.makeText(getApplicationContext(), "Numărul de telefon este invalid.", Toast.LENGTH_LONG).show();
            return;
        }

        // validate country
        if (country.length() == 0 || !country.toLowerCase().matches("[a-z][a-z]{2,}")) {
            Toast.makeText(getApplicationContext(), "Ţara este invalidă.", Toast.LENGTH_LONG).show();
            return;
        }

        UserData userInformation = new UserData(firstName, lastName, phone, country);
        dbUsers.child(currentUserId).setValue(userInformation);
        startActivity(new Intent(getApplicationContext(), QuestionActivity.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}