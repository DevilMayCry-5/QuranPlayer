package com.pho.dmc.quranplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SurahsByJabir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // creating an arraylist
        final ArrayList<Item> surahs = new ArrayList<>();

        //adding items to arraylist
        surahs.add(new Item("Al-Fatiha", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Al-Baqarah", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Aal-e-Imran", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("An-Nisa'a", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Al-Ma'idah", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Al-An'am", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Al-A'raf", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Al-Anfal", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("At-Taubah", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Yunus", "Ali Jabir", R.drawable.rounded_corners_tracks));
        surahs.add(new Item("Hud", "Ali Jabir", R.drawable.rounded_corners_tracks));

        ItemsAdapter itemsAdapter = new ItemsAdapter(this, surahs);
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent toSurahList = new Intent(SurahsByJabir.this, NowPlayingActivity.class);
                toSurahList.putExtra("surah", surahs.get(position));
                startActivity(toSurahList);
            }
        });

        FloatingActionButton nowPlaying = findViewById(R.id.floatingActionButton);

        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SurahsByJabir.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}