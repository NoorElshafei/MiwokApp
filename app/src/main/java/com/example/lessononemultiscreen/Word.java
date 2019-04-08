package com.example.lessononemultiscreen;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int image;




    public Word(String mDefaultTranslation, String mMiwokTranslation,int image) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.image=image;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }
    public int getImage() {
        return image;
    }
}
