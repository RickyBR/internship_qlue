package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_hero;
    private RequestQueue requestQueue;
    private List<Hero> heroList;
    HeroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_hero = findViewById(R.id.rv_hero);
        rv_hero.setHasFixedSize(true);
        rv_hero.setLayoutManager(new LinearLayoutManager(this));
        rv_hero.setAdapter(adapter);
        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        heroList = new ArrayList<>();

        fetchMovies();
    }

    private void fetchMovies() {

        String url = "https://api.opendota.com/api/herostats";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0 ; i < response.length() ; i ++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String name = jsonObject.getString("localized_name");
                                String type = jsonObject.getString("attack_type");
                                String attribute = jsonObject.getString("base_str");
                                String health = jsonObject.getString("base_health");
                                String max_att = jsonObject.getString("base_attack_max");
                                String speed = jsonObject.getString("move_speed");
                                String roles = jsonObject.getString("roles");
                                String image = jsonObject.getString("img");

                                String urlimg = "https://api.opendota.com" + image;

                                Hero hero = new Hero(id ,name, type, attribute, health, max_att, speed, roles, urlimg);
                                heroList.add(hero);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            HeroAdapter adapter = new HeroAdapter(MainActivity.this , heroList);

                            rv_hero.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}