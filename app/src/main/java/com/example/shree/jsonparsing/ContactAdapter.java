package com.example.shree.jsonparsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shree on 27-03-2018.
 */

public class ContactAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ContactAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);

    }


    public int getCount() {
        return list.size();
    }


    public Object getItem(int position) {
        return list.get(position);
    }


    public View getView(int position,  View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        ContactHolder contactHolder;

        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.tvName=row.findViewById(R.id.tvName);
            contactHolder.tvDescription=row.findViewById(R.id.tvDescription);
            contactHolder.tvId=row.findViewById(R.id.tvId);
            row.setTag(contactHolder);


        }
        else{

            contactHolder= (ContactHolder) row.getTag();

        }
        Contacts contacts= (Contacts) this.getItem(position);
        contactHolder.tvName.setText("Name :- "+contacts.getName());
        contactHolder.tvDescription.setText("Details :- "+contacts.getDes());
        contactHolder.tvId.setText("Project ID :- "+contacts.getId());


        return row;
    }

    static class ContactHolder
    {
        TextView tvName,tvDescription,tvId;
    }
}
