package com.example.gagan.contacts;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;


public class FourColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflator;
    private ArrayList<User> users;
    private int mViewResourceId;


    public FourColumn_ListAdapter(Context context,int textViewResourceId,ArrayList<User> users){
        super(context,textViewResourceId,users);
        this.users = users;
        mInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId= textViewResourceId;

    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflator.inflate(mViewResourceId,null);

        User user = users.get(position);
        if(user != null)
        {
            TextView FirstName = (TextView) convertView.findViewById(R.id.textFirstName);
            TextView LastName = (TextView) convertView.findViewById(R.id.texLastName);
            TextView Number = (TextView) convertView.findViewById(R.id.textNumber);
            TextView Email = (TextView) convertView.findViewById(R.id.textEmail);


            if(FirstName != null){
                FirstName.setText((user.getFirstName()));
            }

            if(LastName != null){
                LastName.setText((user.getLastName()));
            }
            if(Number != null){
                Number.setText((user.getNumber()));
            }
            if(Email != null){
                Email.setText((user.getEmail()));


            }
        }
        return convertView;
    }
}
