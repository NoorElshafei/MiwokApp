package com.example.lessononemultiscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> wordsColor=new ArrayList<>();

        wordsColor.add(new Word("lutti","black",R.drawable.color_black));
        wordsColor.add(new Word("lutti","brown",R.drawable.color_brown));
        wordsColor.add(new Word("lutti","dusty yellow",R.drawable.color_dusty_yellow));
        wordsColor.add(new Word("lutti","gray",R.drawable.color_gray));
        wordsColor.add(new Word("lutti","green",R.drawable.color_green));
        wordsColor.add(new Word("lutti","mustard yellow",R.drawable.color_mustard_yellow));
        wordsColor.add(new Word("lutti","red",R.drawable.color_red));
        wordsColor.add(new Word("lutti","white",R.drawable.color_white));


        WordAdapter AdapterColor=new WordAdapter(this,wordsColor,R.color.colorCategory);

        Log.i("NumbersActivity", "After definition of adapter");
        ListView listView =findViewById(R.id.list_color);
        listView.setAdapter(AdapterColor);
        Log.i("NumbersActivity", "finish");
    }
}
