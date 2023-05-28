package com.example.matha_puzzle;

import static android.net.wifi.SupplicantState.COMPLETED;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Winpage extends AppCompatActivity {

    TextView continue1,main_manu,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winpage);
        no = findViewById(R.id.winpage_completed);
        main_manu = findViewById(R.id.winpage_Mainmenu);
        continue1 = findViewById(R.id.winpage_continue);
        int levelNo = getIntent().getIntExtra("levelNo",0);
        no.setText("PUZZLE"+" "+levelNo+" COMPLETED");
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