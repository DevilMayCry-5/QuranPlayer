package com.pho.dmc.quranplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView surah = findViewById(R.id.surahs);
        TextView reciter = findViewById(R.id.reciters);

        surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surahList = new Intent(MainActivity.this, AllSurahsActivity.class);
                startActivity(surahList);
            }
        });

        reciter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reciterList = new Intent(MainActivity.this, RecitersActivity.class);
                startActivity(reciterList);
            }
        });


    }
}