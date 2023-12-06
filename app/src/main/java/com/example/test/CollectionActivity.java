package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Data.Entity.AppDatabase;
import com.example.test.Data.Entity.Skin;
import com.example.test.Data.Entity.SkinAdapterRecycler;
import com.example.test.Data.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {

    private RecyclerView skinsView;

    private TextView coinText;
    private ArrayList<Integer> IntegerArrayList;
    private AppDatabase database;
    private Button Buybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        database = AppDatabase.getInstance(getApplicationContext());

        coinText = findViewById(R.id.coinText);
        coinText.setText(String.valueOf(database.userDao().getCoin(1)));

        IntegerArrayList = new ArrayList<>();
        IntegerArrayList.add(R.drawable.redbird2);
        IntegerArrayList.add(R.drawable.bluebird2);
        IntegerArrayList.add(R.drawable.yellowbird2);

        try {
            SkinAdapterRecycler adapter2 = new SkinAdapterRecycler(database.skinDao().getAll(), this, IntegerArrayList);
            skinsView = findViewById(R.id.recyclerView);
            skinsView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
            skinsView.setItemAnimator(new DefaultItemAnimator());
            skinsView.setAdapter(adapter2);
        }  catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        skinsView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

    }

//    @SuppressLint("NotifyDataSetChanged")
//    private void getData() {
//        skins.clear();
//        skins.addAll(database.skinDao().getAll());
//        skinAdapter.notifyDataSetChanged();
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        getData();
//    }

}