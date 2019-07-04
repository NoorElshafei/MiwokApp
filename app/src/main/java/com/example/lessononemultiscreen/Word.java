package com.example.lessononemultiscreen;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int image=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int sound;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int image,int sound) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.image=image;
        this.sound=sound;
    }
    public Word(String mDefaultTranslation, String mMiwokTranslation,int sound) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.sound=sound;
    }


    public boolean hasImage(){
        return image!=NO_IMAGE_PROVIDED;
    }

    public int getSound() {
        return sound;
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

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", image=" + image +
                ", sound=" + sound +
                '}';
    }
}
