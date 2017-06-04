package com.example.mihaipop.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by mihaipop
 */
public class QuestionActivity extends AppCompatActivity {

    private Button butAddQuestion;
    private TextView mQuestion1;
    private TextView mQuestion2;
    private TextView mQuestion3;
    private TextView mQuestion4;
    private Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qestion);

        mFirebase= new Firebase(getApplicationContext());
        butAddQuestion=(Button)findViewById(R.id.addQuestion);
        mQuestion1=(TextView)findViewById(R.id.question1);
        mQuestion2=(TextView)findViewById(R.id.question2);
        mQuestion3=(TextView)findViewById(R.id.question3);
        mQuestion4=(TextView)findViewById(R.id.question4);

        butAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question1= mQuestion1.getText().toString();
                String question2= mQuestion2.getText().toString();
                String question3= mQuestion3.getText().toString();
                String question4= mQuestion4.getText().toString();

                mFirebase.setQuestion(question1,question2,question3,question4);
                startActivity(new Intent(getApplicationContext(),UserAccount.class));
            }
        });

    }
}
