package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseUsers= FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-app-814d6.firebaseio.com/");
    }

    public void login(View v) {

        EditText txtName = (EditText)findViewById(R.id.name);
        String name=txtName.getText().toString();

        EditText txtPass = (EditText)findViewById(R.id.password);
        String password = txtPass.getText().toString();


    }

    public void newAccount(View v) {

        startActivity(new Intent(getApplicationContext(),CreateAccount.class));
    }

}
