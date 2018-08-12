package com.example.gagan.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    DatabaseHelper DBHelper;
    ArrayList<User> userList;
    ListView listView;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DBHelper = new DatabaseHelper(this);
        userList = new ArrayList<>();
        Cursor data = DBHelper.getData();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(SecondActivity.this, "There is no Contact in the List", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3),data.getString(4));
                userList.add(user);
            }
            FourColumn_ListAdapter adapter = new FourColumn_ListAdapter(this, R.layout.contact_layout,userList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }
    public void GotoFirstScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
