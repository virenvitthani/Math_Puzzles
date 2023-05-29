package com.example.matha_puzzle;
import static com.example.matha_puzzle.MainActivity.editor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

public class Levelpage extends AppCompatActivity {

    GridView gridView;
    Levelpage_Adapter levelpage_adapter;
    ImageView next,back;
    int levelNo,cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelpage);
        levelNo = getIntent().getIntExtra("levelNo",0);
        gridView = findViewById(R.id.levelpage_gridview);
        next = findViewById(R.id.levelpage_next);
        back = findViewById(R.id.levelpage_back);
        levelpage_adapter = new Levelpage_Adapter(Levelpage.this, Configfile.levelarr1);
        gridView.setAdapter(levelpage_adapter);
        editor.putString("page","p0");
        editor.commit();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt--;
                if(cnt==1)
                {
                    levelpage_adapter = new Levelpage_Adapter(Levelpage.this, Configfile.levelarr2);
                    gridView.setAdapter(levelpage_adapter);
                    editor.putString("page","p1");
                    editor.commit();
                }

                if(cnt==0)
                {
                    levelpage_adapter = new Levelpage_Adapter(Levelpage.this, Configfile.levelarr1);
                    gridView.setAdapter(levelpage_adapter);
                    editor.putString("page","p0");
                    editor.commit();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                if(cnt==1)
                {
                    levelpage_adapter = new Levelpage_Adapter(Levelpage.this, Configfile.levelarr2);
                    gridView.setAdapter(levelpage_adapter);
                    editor.putString("page","p1");
                    editor.commit();
                }
                if(cnt==2)
                {
                    levelpage_adapter = new Levelpage_Adapter(Levelpage.this, Configfile.levelarr3);
                    gridView.setAdapter(levelpage_adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }
            }
        });
    }
}