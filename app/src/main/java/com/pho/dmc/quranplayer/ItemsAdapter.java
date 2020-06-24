package com.pho.dmc.quranplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<Item> {

    private static final String LOG_TAG = ItemsAdapter.class.getSimpleName();

    public ItemsAdapter(Activity context, ArrayList<Item> Item){
        super(context, 0, Item);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        Item currentItem = getItem(position);

        TextView surahTextView = listItemView.findViewById(R.id.surah_name);
        assert currentItem != null;
        surahTextView.setText(currentItem.getSurahName());

        TextView reciterTextView = listItemView.findViewById(R.id.reciter_name);
        reciterTextView.setText(currentItem.getReciterName());

        ImageView IconView = listItemView.findViewById(R.id.imageView);
        IconView.setImageResource(currentItem.getImageSourceId());

        return listItemView;
    }
}
