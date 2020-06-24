package com.pho.dmc.quranplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecitersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayList<Item> reciters = new ArrayList<>();

        reciters.add(new Item("Muhammad Al-Minshawi", "1 album | 114 surahs", R.drawable.rounded_corners_artists));
        reciters.add(new Item("Abdullah Ali Jabir", "1 album | 114 surahs", R.drawable.rounded_corners_tracks));



        ItemsAdapter itemsAdapter = new ItemsAdapter(this, reciters);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent toSurahList = new Intent();

                        if (position == 0)
                            toSurahList = new Intent(RecitersActivity.this, SurahsByMinshawi.class);

                        if (position == 1)
                            toSurahList = new Intent(RecitersActivity.this, SurahsByJabir.class);

                        startActivity(toSurahList);
            }
        });

        FloatingActionButton nowPlaying = findViewById(R.id.floatingActionButton);

        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecitersActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}