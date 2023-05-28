package com.example.matha_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView continue1,puzzles;
    int levelNo=0;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continue1 = findViewById(R.id.continue_firtspage);
        puzzles = findViewById(R.id.puzzles_firstpage);

        preferences=getSharedPreferences("mypref",MODE_PRIVATE);
        editor=preferences.edit();
        levelNo=preferences.getInt("levelNo",0);

        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondPage_GamePage.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

        puzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Levelpage.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

    }
}