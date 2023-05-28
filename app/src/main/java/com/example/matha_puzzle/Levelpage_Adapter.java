package com.example.matha_puzzle;

import static com.example.matha_puzzle.MainActivity.preferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Levelpage_Adapter extends BaseAdapter {

    Levelpage levelpage;
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

        ImageView lock = convertView.findViewById(R.id.levelpage_lock);
        ImageView tick = convertView.findViewById(R.id.levelpage_tick);
        TextView textView = convertView.findViewById(R.id.level_locknumber);
        String status = preferences.getString("levelstatus"+position,"pending");
        int levelNo = preferences.getInt("levelNo",0);
        textView.setText("");
            if(status.equals("win"))
            {
                lock.setVisibility(convertView.INVISIBLE);
//                tick.setImageResource(R.drawable.tick);
//                textView.setText(""+Configfile.levelarr[position]);
            }
            if(status.equals("skip") || levelNo == position)
            {
                lock.setVisibility(convertView.INVISIBLE);
                textView.setText(""+Configfile.levelarr[position]);
            }
        return convertView;
    }
}
