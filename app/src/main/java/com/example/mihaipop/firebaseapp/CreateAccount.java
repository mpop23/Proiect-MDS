package com.example.mihaipop.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {


    String nume;
    String prenume;
    String user_name;
    String password;
    DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        databaseUsers= FirebaseDatabase.getInstance().getReference("users");

    }


    public int completat() {

        int ct = 0;

        if (nume.isEmpty() == true)
            ct = -1;

        if (prenume.isEmpty() == true)
            ct = -1;

        if (user_name.isEmpty() == true)
            ct = -1;

        if (password.isEmpty() == true)
            ct = -1;

        return ct;
    }

    public int validPassword(String password) {

        if (password.length() < 6)
            return -1;

        boolean validLitera = false;
        for (int i = 0; i < password.length(); i++)
            if ((password.charAt(i) >= 'A') && (password.charAt(i) <= 'Z'))
                validLitera = true;

        boolean validCifra = false;
        for (int i = 0; i < password.length(); i++)
            if ((password.charAt(i) >= '0') && (password.charAt(i) <= '9'))
                validCifra = true;

        if ((validLitera == false) || (validCifra == false))
            return -1;

        return 0;
    }

    public void createAccount(View v) {

        EditText txtname = (EditText) findViewById(R.id.numeN);
        nume = txtname.getText().toString();

        EditText txtprenume = (EditText) findViewById(R.id.prenumeN);
        prenume = txtprenume.getText().toString();

        EditText txtuser_name = (EditText) findViewById(R.id.userN);
        user_name = txtuser_name.getText().toString();

        EditText txtpassword = (EditText) findViewById(R.id.passwordN);
        password = txtpassword.getText().toString();


        if (completat() == -1) {
            Toast myTost = Toast.makeText(getApplicationContext(), "Completati toate campurile", Toast.LENGTH_LONG);
            myTost.show();
            return;
        }

        if (validPassword(password) == -1) {
            Toast myTost = Toast.makeText(getApplicationContext(), "Parola nu contine o litera mare si o cifra", Toast.LENGTH_LONG);
            myTost.show();
            return;
        }

        String id = databaseUsers.push().getKey();
        DataUser user = new DataUser(id,nume,prenume,user_name,password);
        databaseUsers.child(id).setValue(user);
    }
}