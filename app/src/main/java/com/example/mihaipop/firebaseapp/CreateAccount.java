package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class CreateAccount extends AppCompatActivity {
    

    private TextView mUserName;
    private TextView mPassword;
    private Button butCreate;
    private DatabaseReference dbUsers;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAuth=FirebaseAuth.getInstance();
        butCreate= (Button)findViewById(R.id.createN);
        mUserName= (TextView)findViewById(R.id.userN);
        mPassword= (TextView)findViewById(R.id.passwordN);


        butCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
                startActivity(new Intent(getApplicationContext(),UserDetails.class));
            }
        });

    }

    public void create() {

        String user_name = mUserName.getText().toString();
        String password = mPassword.getText().toString();

        if((user_name.equals(""))&&(password.equals(""))) {
            toast("Complet all filds");
            return;
        }

        if(validPassword(password)==-1) {
            toast("Password must have a majuscul and a numer!");
            return;
        }

        mAuth.createUserWithEmailAndPassword(user_name,password);
        mAuth.signInWithEmailAndPassword(user_name, password);

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


    public void toast(String text) {

        Toast mToast= Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        mToast.show();
    }




    /*
    private void showData(DataSnapshot dataSnapshot, String user_name) {

        boolean singleUser=true;
        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            //getting data
            DataUser User = postSnapshot.getValue(DataUser.class);
            if(User.getUser_name().equals(user_name))
                singleUser=false;
        }

        if(singleUser==true) {
            String id = dbUsers.push().getKey();
            DataUser user = new DataUser(id, user_name, password);
            dbUsers.child(id).setValue(user);
        }
        else{
            Toast myToast = Toast.makeText(getApplicationContext(),"Userul deja exista!",Toast.LENGTH_LONG);
            myToast.show();
        }


    }

    public void createAccount(View v) {


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


        databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot,user_name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
    */
}