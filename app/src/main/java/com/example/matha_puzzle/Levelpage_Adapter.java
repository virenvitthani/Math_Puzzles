package com.example.matha_puzzle;

import static com.example.matha_puzzle.MainActivity.preferences;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Levelpage_Adapter extends BaseAdapter {

    Levelpage levelpage;
    TextView textView;
    int[] levelarr;

    public Levelpage_Adapter(Levelpage levelpage, int[] levelarr) {
        this.levelpage = levelpage;
        this.levelarr = levelarr;
    }

    @Override
    public int getCount() {
        return levelarr.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(levelpage).inflate(R.layout.levelpage_item,parent,false);
        String page = preferences.getString("page","pp");

        if(page.equals("p0")) {
            ImageView lock = convertView.findViewById(R.id.levelpage_lock);
            ImageView tick = convertView.findViewById(R.id.levelpage_tick);
            TextView textView = convertView.findViewById(R.id.level_locknumber);
            String status = preferences.getString("levelstatus" + (position + 1), "pending");
            int levelNo = preferences.getInt("levelNo", 0);
            textView.setText("");
            if (status.equals("win")) {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText("" + Configfile.levelarr1[position]);
                tick.setImageResource(R.drawable.tick);
            } else if (status.equals("skip") || levelNo == position) {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText("" + Configfile.levelarr1[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelpage, SecondPage_GamePage.class);
                    intent.putExtra("levelNo", position);
                    levelpage.startActivity(intent);
                }
            });
        }

        if(page.equals("p1")) {
            ImageView lock = convertView.findViewById(R.id.levelpage_lock);
            ImageView tick = convertView.findViewById(R.id.levelpage_tick);
            TextView textView = convertView.findViewById(R.id.level_locknumber);
            String status = preferences.getString("levelstatus" + (position + 21), "pending");
            int levelNo = preferences.getInt("levelNo", 0);
            textView.setText("");
            if (status.equals("win")) {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText("" + Configfile.levelarr1[position]);
                tick.setImageResource(R.drawable.tick);
            } else if (status.equals("skip") || levelNo == position + 21) {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText("" + Configfile.levelarr1[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelpage, SecondPage_GamePage.class);
                    intent.putExtra("levelNo", position+20);
                    levelpage.startActivity(intent);
                }
            });
        }

        if(page.equals("p2")) {
            ImageView lock = convertView.findViewById(R.id.levelpage_lock);
            ImageView tick = convertView.findViewById(R.id.levelpage_tick);
            TextView textView = convertView.findViewById(R.id.level_locknumber);
            String status = preferences.getString("levelstatus" + (position + 41), "pending");
            int levelNo = preferences.getInt("levelNo", 0);
            textView.setText("");
            if (status.equals("win")) {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText("" + Configfile.levelarr1[position]);
                tick.setImageResource(R.drawable.tick);
            } else if (status.equals("skip") || levelNo == position + 41) {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText("" + Configfile.levelarr1[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelpage, SecondPage_GamePage.class);
                    intent.putExtra("levelNo", position+40);
                    levelpage.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}
