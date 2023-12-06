package com.example.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.test.Data.Entity.AppDatabase;
import com.example.test.Data.Entity.Skin;
import com.example.test.Data.Entity.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends Activity {
    private Button btn_enter, shop_btn, skin_btn, collection_btn;

    private User user;
    private List<Skin> skins = new ArrayList<>();
    private AppDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        shop_btn = findViewById(R.id.shop_btn);
        btn_enter = findViewById(R.id.btn_submit);
        skin_btn = findViewById(R.id.skin_btn);
        collection_btn = findViewById(R.id.collection_btn);



        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean firstRun = prefs.getBoolean("firstRun", true);

        if (firstRun) {
            database = AppDatabase.getInstance(getApplicationContext());
            database.skinDao().insertAll(new Skin(1, true, "redbird2.png", 0));
            database.skinDao().insertAll(new Skin(2, false, "bluebird2.png", 5));
            database.skinDao().insertAll(new Skin(3, false, "yellowbird2.png", 10));
            database.userDao().insertAll(new User(1,0,0));

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstRun", false);
            editor.apply();
        }

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),GameActivity.class);
                    startActivity(i);
                    finish();

            }
        });

        shop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ShopActivity.class);
                startActivity(i);
                finish();
            }
        });

        collection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CollectionActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}