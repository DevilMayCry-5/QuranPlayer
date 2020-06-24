package com.pho.dmc.quranplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SurahsByMinshawi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // creating an arraylist
        final ArrayList<Item> surahs = new ArrayList<>();

        //adding items to arraylist
        surahs.add(new Item("Al-Fatiha", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Al-Baqarah", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Aal-e-Imran", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("An-Nisa'a", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Al-Ma'idah", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Al-An'am", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Al-A'raf", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Al-Anfal", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("At-Taubah", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Yunus", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));
        surahs.add(new Item("Hud", "Muhammad Al-Minshawi", R.drawable.rounded_corners_artists));

        ItemsAdapter itemsAdapter = new ItemsAdapter(this, surahs);
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent toSurahList = new Intent(SurahsByMinshawi.this, NowPlayingActivity.class);
                toSurahList.putExtra("surah", surahs.get(position));
                startActivity(toSurahList);
            }
        });

        FloatingActionButton nowPlaying = findViewById(R.id.floatingActionButton);

        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SurahsByMinshawi.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}