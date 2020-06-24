package com.pho.dmc.quranplayer;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String mSurahName;
    private String mReciterName;
    private int mImageSourceId;

    public Item(String surahName, String reciterName, int imageSourceId){
        mSurahName = surahName;
        mReciterName = reciterName;
        mImageSourceId = imageSourceId;
    }

    protected Item(Parcel in) {
        mSurahName = in.readString();
        mReciterName = in.readString();
        mImageSourceId = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getSurahName(){
        return mSurahName;
    }

    public String getReciterName(){
        return mReciterName;
    }

    public int getImageSourceId(){
        return mImageSourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSurahName);
        dest.writeString(mReciterName);
        dest.writeInt(mImageSourceId);
    }
}
