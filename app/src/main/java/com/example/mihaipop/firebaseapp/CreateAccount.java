package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * Created by mihaipop
 */

public class CreateAccount extends AppCompatActivity {

    private TextView mUserName;
    private TextView mPassword;
    private Button butCreate;
    private Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        butCreate = (Button)findViewById(R.id.createN);
        mUserName = (TextView)findViewById(R.id.userN);
        mPassword = (TextView)findViewById(R.id.passwordN);
        myFirebase = new Firebase(getApplicationContext());

        butCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAcc();
            }
        });
    }

    public void createAcc() {

        String user_name = mUserName.getText().toString();
        String password = mPassword.getText().toString();
        boolean ok = true;
        boolean create = false;

        if ((!Validation.validString(user_name)) || (!Validation.validString(password))){
            toast("Completează toate câmpurile.");
            ok = false;
        }

        if (!Validation.validPassword(password)){
            toast("Parola trebuie să conţină cel puţin 6 caractere, numere şi litere.");
            ok = false;
        }

        if(ok == true){

            myFirebase.getmAuth().createUserWithEmailAndPassword(user_name, password) 
                    .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                startActivity(new Intent(getApplicationContext(), UserDetails.class));
                                finish();

                            }else{

                                toast( "Emailul deja exista!" );
                            }

                        }
                    });
            }

    }

    public void toast(String text) {

        Toast mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
        mToast.show();
    }
}