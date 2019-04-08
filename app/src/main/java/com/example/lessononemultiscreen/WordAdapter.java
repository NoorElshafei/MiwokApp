package com.example.lessononemultiscreen;

import android.app.Activity;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Context context, int resource,List<Word> objects) {
        super(context, resource, objects);
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
        imageView.setImageResource(currentWord.getImage());
        return listItemView;
    }
}
