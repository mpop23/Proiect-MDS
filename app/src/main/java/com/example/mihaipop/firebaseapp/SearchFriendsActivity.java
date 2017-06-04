package com.example.mihaipop.firebaseapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alinacucu on 03/06/2017.
 */

public class SearchFriendsActivity extends android.app.Activity {

    private ArrayAdapter<String> adapter;
    private ListView lv;                                            // List view
    private EditText inputSearch;                                   // Search EditText
    private ArrayList<MyPair> users;
    private ArrayList<String> q;
    private Firebase mFirebase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friends);

        lv = (ListView) findViewById(R.id.list_view);               // Listview Data
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        mFirebase= new Firebase(getApplicationContext());
        users = new ArrayList<>();
        q=new ArrayList<>();

        inputSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                q.clear();
                String name = inputSearch.getText().toString();
                mFirebase.snapShot(users,name);


                for(int i=0;i<users.size();i++) {
                    q.add(users.get(i).getLast());
                }

                newAdaptor();

                lv.setAdapter(adapter);
                /**
                 * Enabling Search Filter
                 * */
                inputSearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged( CharSequence cs, int arg1, int arg2, int arg3) {
                        // When user changed the Text
                        SearchFriendsActivity.this.adapter.getFilter().filter(cs);
                    }

                    @Override
                    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                  int arg3) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void afterTextChanged(Editable arg0) {
                        // TODO Auto-generated method stub
                    }
                });

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String s =""+ lv.getItemAtPosition(i)+" "+i;
                        toast(s);
                        //nuw activity!
                    }
                });
                users.clear();

            }

        });

    }

    public void toast(String text) {

        Toast mToast= Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        mToast.show();
    }

    public void newAdaptor(){

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, q);//Adding items to listview

    }

}

