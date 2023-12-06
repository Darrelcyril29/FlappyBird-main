package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GameActivity extends AppCompatActivity {
   public static TextView txt_score, txt_best_score, txt_score_over;
   public static RelativeLayout rl_game_over;
   private GameView gv;
   public static Button btn_start, btn_shop, skins_btn, collection_btn;
   private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_game);

        txt_score = findViewById(R.id.txt_score);
        txt_best_score=findViewById(R.id.txt_best_score);
        txt_score_over=findViewById(R.id.txt_score_over);
        rl_game_over = findViewById(R.id.rl_game_over);
        btn_start = findViewById(R.id.btn_start);
        skins_btn = findViewById(R.id.skins_btn);
        gv = findViewById(R.id.gv);
        btn_shop = findViewById(R.id.game_shop);
        collection_btn = findViewById(R.id.collection_btn);


        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               gv.setStart(true);
               txt_score.setVisibility(View.VISIBLE);
               btn_start.setVisibility(View.INVISIBLE);
               btn_shop.setVisibility(View.INVISIBLE);
               skins_btn.setVisibility(View.INVISIBLE);
               collection_btn.setVisibility(View.INVISIBLE);

            }
        });
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShopActivity.class);
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

        rl_game_over.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btn_start.setVisibility(View.VISIBLE);
                btn_shop.setVisibility(View.VISIBLE);
                skins_btn.setVisibility(View.VISIBLE);
                rl_game_over.setVisibility(View.INVISIBLE);
                collection_btn.setVisibility(View.VISIBLE);
                gv.setStart(false);
                gv.reset();

            }
        });
        mediaPlayer = MediaPlayer.create(this,R.raw.sillychipsong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


    }

    @Override
    protected void onResume(){
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mediaPlayer.pause();
    }


}