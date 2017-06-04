package com.example.mihaipop.firebaseapp;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckedTextView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * Created by mihaipop on 27/05/2017.
 */

public class Firebase extends AppCompatActivity {


    private DatabaseReference dbUsers;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String idUser;
    private Context context;
    private static final String TAG = "Firebase";




    Firebase(Context context) {

        this.context=context;
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbUsers= FirebaseDatabase.getInstance().getReference("users");
        if(user!=null)
            idUser=user.getUid();

    }

    public boolean createAcc(String user, String password) {

        mAuth.createUserWithEmailAndPassword(user,password);
        mAuth.signInWithEmailAndPassword(user, password);
        if (mAuth.getCurrentUser() == null)
            return false;
        return true;
    }


    public void  snapShot(final CheckedTextView description,final TextView noFriends,final TextView noQuestion) {



        dbUsers.addValueEventListener(new ValueEventListener() {

            @Override
            public void  onDataChange(DataSnapshot dataSnapshot) {

                    showDecription(dataSnapshot, description, noFriends, noQuestion);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public void  snapShot(final TextView firstname,final TextView lastname,final TextView country,final TextView phone,final Switch privat) {



        dbUsers.addValueEventListener(new ValueEventListener() {


            @Override
            public void  onDataChange(DataSnapshot dataSnapshot) {

                getAccountInfo(dataSnapshot, firstname, lastname, country,phone,privat);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    public void  snapShot(final ArrayList<Pair> users, final String name) {



        dbUsers.addValueEventListener(new ValueEventListener() {


            @Override
            public void  onDataChange(DataSnapshot dataSnapshot) {

                getListUsers(dataSnapshot,users,name);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void showDecription(DataSnapshot dataSnapshot, CheckedTextView description, TextView noFriends, TextView noQuestion) {

        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            //get data
            String id=postSnapshot.getKey();
            UserData User= new UserData();

            if(id.equals(idUser)) {
                User.setDescription(postSnapshot.getValue(UserData.class).getDescription());
                User.setNoFriends(postSnapshot.getValue(UserData.class).getNoFriends());
                User.setNoQuestion(postSnapshot.getValue(UserData.class).getNoQuestion());
                description.setText(User.getDescription());
                noFriends.setText(""+User.getNoFriends());
                noQuestion.setText((""+User.getNoQuestion()));

            }
        }

    }


    public void changeDescription(String description)  {

        dbUsers.child(idUser).child("description").setValue(description);

    }

    public void setQuestion(String question1,String question2,String question3,String question4){

        Question question = new Question(question1,question2,question3,question4);
        dbUsers.child(idUser).child("question").setValue(question);
    }

    public void setPrivat(String privat){
        dbUsers.child(idUser).child("privat").setValue(privat);
    }

    public void getAccountInfo( DataSnapshot dataSnapshot,TextView firstname, TextView lastname, TextView country, TextView phone,Switch privat){


        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            //get data
            String id=postSnapshot.getKey();

            if(id.equals(idUser)) {

                firstname.setText("First Name: "+postSnapshot.getValue(UserData.class).getFirstName());
                lastname.setText("Last Name: "+postSnapshot.getValue(UserData.class).getLastName());
                country.setText("Country:"+postSnapshot.getValue(UserData.class).getCountry());
                phone.setText("Phone: "+postSnapshot.getValue(UserData.class).getPhone());
                String check=postSnapshot.getValue(UserData.class).getPrivat();

                if(check.equals("Da"))
                    privat.setChecked(true);
                else
                    privat.setChecked(false);

            }
        }
    }

    public void getListUsers(DataSnapshot dataSnapshot, ArrayList<Pair> users, String name){
        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            //get data
            String id=postSnapshot.getKey();
            UserData User= new UserData();

            if(!id.equals(idUser)) {

                String name1="";
                String name2="";
                name1+=postSnapshot.getValue(UserData.class).getFirstName()+" ";
                name1+=postSnapshot.getValue(UserData.class).getLastName();
                name2+=postSnapshot.getValue(UserData.class).getLastName()+" ";
                name2+=postSnapshot.getValue(UserData.class).getFirstName();

                if((name.equals(name1)) || (name.equals(name2))){
                    Pair myPair= new Pair(id,name);
                    users.add(myPair);
                }
            }
        }

    }

    public void signOut() {
        // Firebase sign out
        mAuth.signOut();
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

    public void toast(String text){

        Toast mToast =Toast.makeText(context,text,Toast.LENGTH_LONG);
        mToast.show();
    }


    /*
    public void  details(UserData userInformation){

        dbUsers= FirebaseDatabase.getInstance().getReference("users");
        dbUsers.child(idUser).setValue(userInformation);

    }
    */
}