package com.example.matha_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Levelpage extends AppCompatActivity {

    GridView gridView;
    Levelpage_Adapter levelpage_adapter;
    int levelNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelpage);
        levelNo = getIntent().getIntExtra("levelNo",0);
        gridView = findViewById(R.id.levelpage_gridview);
        levelpage_adapter = new Levelpage_Adapter(Levelpage.this, Configfile.levelarr);
        gridView.setAdapter(levelpage_adapter);
    }
}