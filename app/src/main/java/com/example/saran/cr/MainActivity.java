package com.example.saran.cr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv1;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListClass> arrayList;
    String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = (RecyclerView)findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>();

        rv1.setHasFixedSize(true);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
            @Override
            public void onResponse(String response)
            {
                JSONObject jsonObject;
                JSONArray jsonArray;

                try
                {
                 jsonObject = new JSONObject(response);
                 jsonArray = jsonObject.getJSONArray("worldpopulation");

                    for (int i = 0; i <jsonArray.length() ; i++)
                    {
                        JSONObject country = (JSONObject)jsonArray.get(i);
                            String countries = country.getString("rank");
                            String countries1 = country.getString("country");
                            String countries2 = country.getString("population");
                            String countries3 = country.getString("flag");
                            ListClass listClass = new ListClass(countries,countries1,countries2,countries3);
                            arrayList.add(listClass);
                    }

                    adapter = new CustomAdapter(MainActivity.this,arrayList);
                    rv1.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener()
                {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        })

        {

        };
        requestQueue.add(stringRequest);


    }
}
