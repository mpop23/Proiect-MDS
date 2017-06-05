package com.example.mihaipop.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by mihaipop on 03/06/2017.
 */

public class AccountInfoActivity extends AppCompatActivity {


    private Firebase mFirebase;
    private TextView firstname;
    private TextView lastname;
    private TextView country;
    private TextView phone;
    private Switch privat;
    private TextView description;
    private Button butAddDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        mFirebase = new Firebase(getApplicationContext());
        firstname = (TextView)findViewById(R.id.infoFirstname);
        lastname = (TextView)findViewById(R.id.infoLastname);
        country = (TextView)findViewById(R.id.infoCountry);
        phone = (TextView)findViewById(R.id.infoPhone);
        privat =(Switch)findViewById(R.id.infoPrivat);
        butAddDescription = (Button)findViewById(R.id.addDescription);

        butAddDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = (TextView)findViewById(R.id.changeDescription);
                String changeDescription = description.getText().toString();

                if(Validation.validString(changeDescription)) {
                    mFirebase.changeDescription(changeDescription);
                    Util.showMessage(getApplicationContext(), "Descrierea a fost schimbată.");
                }
            }
        });

        mFirebase.snapShot(firstname, lastname, country, phone, privat);

        privat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == false){
                    mFirebase.setPrivat("Nu");
                }
                else{
                    mFirebase.setPrivat("Da");
                }
            }
        });
    }

}
