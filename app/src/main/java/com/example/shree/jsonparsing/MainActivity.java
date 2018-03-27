package com.example.shree.jsonparsing;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnGetJson,btnParseJson;
    String JSON_STRING,JSON_PARSE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetJson=findViewById(R.id.btnGetJson);
        btnParseJson=findViewById(R.id.btnParseJson);

        btnGetJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundTask().execute();
            }
        });

        btnParseJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(JSON_PARSE==null)
                {
                    Toast.makeText(getApplicationContext(),"GetJSON data ",Toast.LENGTH_LONG).show();

                }
                else{
                    Intent i=new Intent(MainActivity.this,DisplayListView.class);
                    i.putExtra("data",JSON_PARSE);
                    startActivity(i);
                }
            }
        });
    }
    class BackgroundTask extends AsyncTask<Void,Void,String>{

        String json_url;
        @Override
        protected void onPreExecute() {
            json_url="http://ffca2b72.ngrok.io/json_get_data.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while((JSON_STRING=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tvDisplay=findViewById(R.id.tvDisplay);;
            tvDisplay.setText(result);
            JSON_PARSE=result;


        }
    }
}
