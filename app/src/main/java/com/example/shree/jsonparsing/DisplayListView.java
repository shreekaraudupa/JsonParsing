package com.example.shree.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);


        contactAdapter=new ContactAdapter(this,R.layout.row_layout);
        listView=findViewById(R.id.lvDisplay);
        listView.setAdapter(contactAdapter);
        json_string=getIntent().getExtras().getString("data");

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;
            String RName,Rdes,Rid;

            while(count<jsonArray.length()){
                JSONObject jo=jsonArray.getJSONObject(count);
                RName=jo.getString("name");
                Rdes=jo.getString("details");
                Rid=jo.getString("project_id");
                Contacts contacts=new Contacts(RName,Rdes,Rid);
                contactAdapter.add(contacts);
                count++;


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
