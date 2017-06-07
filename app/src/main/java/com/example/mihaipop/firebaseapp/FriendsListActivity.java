package com.example.mihaipop.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FriendsListActivity extends AppCompatActivity {
    private TextView message;
    private ListView friendsList;
    private Firebase firebase;
    private FirebaseDatabase database;
    private DatabaseReference friendsRef;
    private ArrayAdapter<String> adapter;

    private String fullName = "";

    /**
     * list containing the id's on the current logged user
     */
    private List<String> friendsID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        firebase = new Firebase(getApplicationContext());
        String currentUserId = firebase.getIdUser();

        message = (TextView)findViewById(R.id.friendsListMessage);
        friendsList = (ListView)findViewById(R.id.friendsListfriends);



        database = FirebaseDatabase.getInstance();
        friendsRef = database.getReference()
                             .child("users")
                             .child(firebase.getIdUser())
                             .child("friends");

        DatabaseReference userReference = database.getReference()
                                                  .child("users")
                                                  .child(firebase.getIdUser());

        userReference.child("firstName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fullName += dataSnapshot.getValue().toString();
                fullName += " ";
                message.setText(fullName);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        userReference.child("lastName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fullName += dataSnapshot.getValue().toString();
                message.setText(fullName);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



//        message.setText(fullName);

        friendsID = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendsID);

        friendsList.setAdapter(adapter);


        friendsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot friend : dataSnapshot.getChildren()) {
                    friendsID.add(friend.getValue().toString());
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}


