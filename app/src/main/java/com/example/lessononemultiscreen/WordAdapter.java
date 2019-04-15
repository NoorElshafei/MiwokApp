package com.example.lessononemultiscreen;

import android.app.Activity;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourcId;



    public WordAdapter(Context context,List<Word> objects,int colorResourceId) {
        super(context,0, objects);
        this.mColorResourcId=colorResourceId;
        Log.i("WordAdapter", "constructor of WordAdapter");
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Log.i("WordAdapter", "getView of WordAdapter");
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        Log.i("WordAdapter", "getView of WordAdapter+ position"+position);

        TextView moiwokTextView = listItemView.findViewById(R.id.miowk_text_view);
        moiwokTextView.setText(currentWord.getmMiwokTranslation());
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        ImageView imageView=listItemView.findViewById(R.id.miowk_image_view);

        if(currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImage());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer= listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColorResourcId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
