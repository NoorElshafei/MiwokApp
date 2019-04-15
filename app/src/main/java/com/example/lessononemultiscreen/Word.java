package com.example.lessononemultiscreen;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int image=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;


    public Word(String mDefaultTranslation, String mMiwokTranslation, int image) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.image=image;
    }
    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;



    }


    public boolean hasImage(){
        return image!=NO_IMAGE_PROVIDED;
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
