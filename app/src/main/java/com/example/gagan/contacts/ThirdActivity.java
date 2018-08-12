package com.example.gagan.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.gagan.contacts.R.id.buttonAdd;

public class ThirdActivity extends AppCompatActivity {

    DatabaseHelper DBHelper;
    EditText firstName, lastName,numBer,eMail;
    Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        firstName = (EditText) findViewById(R.id.givenName);
        lastName = (EditText) findViewById(R.id.familyName);
        numBer = (EditText) findViewById(R.id.number);
        eMail = (EditText) findViewById(R.id.email);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnView = (Button) findViewById(R.id.buttonView);
        DBHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName =  firstName.getText().toString();
                String lName =  lastName.getText().toString();
                String num =  numBer.getText().toString();
                String email =  eMail.getText().toString();
                if(fName.length() != 0 && lName.length() !=0 && num.length() !=0 && email.length() !=0){
                    AddContact(fName,lName,num,email);
                    firstName.setText("");
                    lastName.setText("");
                    numBer.setText("");
                    eMail.setText("");

                }
                else {
                    Toast.makeText(ThirdActivity.this, "All the Fields Must be Completed before Saving ",Toast.LENGTH_LONG).show();
                }

            }

            public void AddContact(String firstName,String lastName,String Number,String email){
                boolean insertData = DBHelper.addData(firstName,lastName,Number,email);

                if(insertData==true){
                    Toast.makeText(ThirdActivity.this, "New Contact Added Succesfully",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(ThirdActivity.this, "All the Fields Must be Completed before Saving ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void GotoFirstScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
