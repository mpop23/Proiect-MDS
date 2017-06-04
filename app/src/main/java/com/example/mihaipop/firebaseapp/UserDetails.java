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

    private TextView mFirstName;
    private TextView mLastName;
    private TextView mPhone;
    private TextView mCountry;
    private DatabaseReference dbUsers;
    private FirebaseAuth mAuth;
    private  FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button butAddDetails;
    private String idUser;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        dbUsers= FirebaseDatabase.getInstance().getReference("users");
        mFirstName =(TextView) findViewById(R.id.firstnameD);
        mLastName =(TextView)findViewById(R.id.lastnameD);
        mPhone = (TextView) findViewById(R.id.phoneD);
        mCountry = (TextView) findViewById(R.id.countryD);
        butAddDetails=(Button) findViewById(R.id.addDataD);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user!= null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    idUser=user.getUid();

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");

                }
                // ...
            }
        };

        butAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();

            }
        });

    }


    public void addData() {


        String firstName=mFirstName.getText().toString();
        String lastName=mLastName.getText().toString();
        String phone=mPhone.getText().toString();
        String country=mCountry.getText().toString();

        if(!firstName.equals("")  && !lastName.equals("") && !phone.equals("")  &&!country.equals("") ){
            DataUser userInformation = new DataUser(firstName,lastName,phone,country);
            dbUsers.child(idUser).setValue(userInformation);
            startActivity(new Intent(getApplicationContext(),QuestionActivity.class));
        }
        else{
            Toast myToast = Toast.makeText(getApplicationContext(),"Completati toate campurile",Toast.LENGTH_LONG);
            myToast.show();
        }
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