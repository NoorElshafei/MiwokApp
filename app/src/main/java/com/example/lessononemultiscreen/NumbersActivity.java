package com.example.lessononemultiscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word>words=new ArrayList<>();

        words.add(new Word("lutti","one",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","two",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","three",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","four",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","five",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","six",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","seven",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","eight",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","nine",R.drawable.ic_launcher_background));
        words.add(new Word("lutti","ten",R.drawable.ic_launcher_background));

        WordAdapter Adapter=new WordAdapter(this,R.layout.list_item,words);
        Log.i("NumbersActivity", "After defination of adapter");
        ListView listView =findViewById(R.id.list);
        listView.setAdapter(Adapter);
        Log.i("NumbersActivity", "finish");



    }

}
