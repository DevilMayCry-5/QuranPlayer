package com.pho.dmc.quranplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    private  MediaPlayer mediaPlayer;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        mediaPlayer = MediaPlayer.create(this, R.raw.naml);
        mediaPlayer.start();

        /**
         * Gets data from clicked item in Surah List
         * and sets the corresponding text and image views
         * in the NowPlayingActivity Activity with that data
         */
        Intent intent = getIntent();
        Item surah = intent.getParcelableExtra("surah");

        assert surah != null;
        int npImage = surah.getImageSourceId();
        String npSurah = surah.getSurahName();
        final String npReciter = surah.getReciterName();

        ImageView img = findViewById(R.id.now_playing_imageView);
        img.setImageResource(npImage);

        TextView surahName = findViewById(R.id.now_playing_surah_name);
        surahName.setText(npSurah);

        TextView reciterName = findViewById(R.id.now_playing_reciter_name);
        reciterName.setText(npReciter);

        /**
         * Changes the play button to pause button and vice versa
         * when it's clicked
         */
        final ImageView currentButton = findViewById(R.id.play_btn);
        final Drawable pauseButton = getDrawable(android.R.drawable.ic_media_pause);
        final Drawable playButton = getDrawable(android.R.drawable.ic_media_play);
        currentButton.setImageDrawable(pauseButton);

        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable currentBtn = currentButton.getDrawable();

                if (currentBtn == playButton) {
                    currentButton.setImageDrawable(pauseButton);
                    mediaPlayer.start();

                }
                else if (currentBtn == pauseButton) {
                    currentButton.setImageDrawable(playButton);
                    mediaPlayer.pause();
                }
            }
        });



        surahName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        reciterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "Ali Jabir";
                String m = "Muhammad Al-Minshawi";
                if (npReciter.equals(a)){
                    Intent ali = new Intent(NowPlayingActivity.this, SurahsByJabir.class);
                    startActivity(ali);
                }
                if (npReciter.equals(m)){
                    Intent minshawi = new Intent(NowPlayingActivity.this, SurahsByMinshawi.class);
                    startActivity(minshawi);
                }
            }
        });



    }
}