package com.example.matha_puzzle;
import static com.example.matha_puzzle.MainActivity.editor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondPage_GamePage extends AppCompatActivity implements View.OnClickListener {

    TextView[] b=new TextView[10];
    ImageView imageView,delete,skip;
    TextView ans,submit,levelboard;
    String s="";
    String s1;
    int a=0,cnt;
    int levelNo=0;
    private ArrayList<String> imgArr=new ArrayList<>();
    private List<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page_game_page);
        imageView = findViewById(R.id.secondpage_image);
        levelNo=getIntent().getIntExtra("levelNo",0);
        levelboard = findViewById(R.id.secondpage_levelboard);
        ans = findViewById(R.id.secondpage_ans);
        delete = findViewById(R.id.secondpage_delete);
        submit = findViewById(R.id.secondpage_submit);
        skip = findViewById(R.id.secondpage_skip);
        getImage();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(levelNo<49) {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(SecondPage_GamePage.this);
                    builder1.setTitle("SKIP");
                    builder1.setMessage("Are you sure you want to skip this level? you can play skipped" +
                            "leves later by clicking on PUZZLES menu from main screen.");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "CANCEL",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    builder1.setNegativeButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    levelNo++;
                                    getImage();
                                    levelboard.setText("LEVEL "+(levelNo+1));
                                    editor.putInt("levelNo",levelNo);
                                    editor.putString("levelstatus"+(levelNo),"skip");
                                    editor.commit();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        });

        for(int i=0;i<b.length;i++) {
            int id = getResources().getIdentifier("b"+i,"id",getPackageName());
            b[i] = findViewById(id);
            b[i].setOnClickListener(this);
        }

        levelboard.setText("PUZZLE"+" "+""+(levelNo+1));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans.length()>0)
                {
                    String d=s1.substring(0,ans.length()-1);
                    ans.setText(d);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TTT", "onClick: Submit");
                if(ans.getText().toString().equals(Configfile.ansarr[levelNo]))
                {
                    levelNo++;

                    editor.putInt("levelNo",levelNo);
                    editor.putString("levelStatus"+levelNo,"win");
                    editor.commit();

                    Intent intent=new Intent(SecondPage_GamePage.this,Winpage.class);
                    intent.putExtra("levelNo",levelNo);
                    startActivity(intent);
                }
                else
                {
                    Toast toast=Toast. makeText(SecondPage_GamePage.this,"Wrong Answer!!!",Toast. LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }
    private void getImage()
    {
        String[] images = new String[0];
        try {
            images = getAssets().list("images/");
            imgArr = new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        Collections.sort(imgArr);
        Log.d("TTT", "befor: All images="+imgArr);
        arrayList=imgArr.subList(3,imgArr.size()-1);
        Log.d("TTT", "after: All images="+arrayList);
        InputStream inputstream = null;
        try {
            inputstream = getAssets().open("images/"+arrayList.get(levelNo));
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            //System.out.println("input Stream="+drawable);
            imageView.setImageDrawable(drawable);
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        for (int i=0;i<b.length;i++) {
            if(v.getId()==b[i].getId()) {
                s1= (String) ans.getText();
                s=s1+i;
                ans.setText(""+s);
            }
        }
    }
}