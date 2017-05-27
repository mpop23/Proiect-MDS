package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private TextView mUserName;
    private TextView mPassword;
    private Button butSingIn;
    private Button butSingUp;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName=(EditText)findViewById(R.id.name);
        mPassword=(EditText)findViewById(R.id.password);
        butSingIn=(Button)findViewById(R.id.login);
        butSingUp=(Button)findViewById(R.id.create);
        mAuth=FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user!= null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    startActivity((new Intent(getApplicationContext(),UserAccount.class)));

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");

                }
                // ...
            }
        };

        butSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        butSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateAccount.class));
            }
        });

    }

    public void login() {

        String userName=mUserName.getText().toString();
        String password=mPassword.getText().toString();

        if((!userName.equals(""))&&(!password.equals(""))) {
            mAuth.signInWithEmailAndPassword(userName, password);

        }
        else {
            toast("Complet all of filds");
        }

    }

    public void toast(String text){

        Toast mToast =Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        mToast.show();
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


    /*

    private void loginData(DataSnapshot dataSnapshot, String name,String password) {

        boolean login=false;

        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            //get data
            DataUser User = postSnapshot.getValue(DataUser.class);

           if((User.getUser_name().equals(name))&&(User.getPassword().equals(password)))
                login=true;
        }


        if(login==true) {
            startActivity((new Intent(getApplicationContext(),UserAccount.class)));
        }
        else {
            Toast myToast = Toast.makeText(getApplicationContext(), "User sau parola incorecta!", Toast.LENGTH_LONG);
            myToast.show();
        }

    }

    public void login(View v) {

        EditText txtName = (EditText)findViewById(R.id.name);
        name=txtName.getText().toString();

        EditText txtPass = (EditText)findViewById(R.id.password);
        password = txtPass.getText().toString();


          databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                loginData(dataSnapshot,name,password);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void newAccount(View v) {

        startActivity(new Intent(getApplicationContext(),CreateAccount.class));
    }
    */
}
