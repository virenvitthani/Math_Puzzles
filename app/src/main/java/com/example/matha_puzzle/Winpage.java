package com.example.matha_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Winpage extends AppCompatActivity {

    TextView continue1,main_manu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winpage);

        main_manu = findViewById(R.id.winpage_Mainmenu);
        continue1 = findViewById(R.id.winpage_continue);
        int levelNo = getIntent().getIntExtra("levelNo",0);

        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Winpage.this,SecondPage_GamePage.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

        main_manu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winpage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}