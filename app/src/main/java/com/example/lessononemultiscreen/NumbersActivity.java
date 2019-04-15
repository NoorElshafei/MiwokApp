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

        words.add(new Word("lutti","one",R.drawable.number_one));
        words.add(new Word("lutti","two",R.drawable.number_two));
        words.add(new Word("lutti","three",R.drawable.number_three));
        words.add(new Word("lutti","four",R.drawable.number_four));
        words.add(new Word("lutti","five",R.drawable.number_five));
        words.add(new Word("lutti","six",R.drawable.number_six));
        words.add(new Word("lutti","seven",R.drawable.number_seven));
        words.add(new Word("lutti","eight",R.drawable.number_eight));
        words.add(new Word("lutti","nine",R.drawable.number_nine));
        words.add(new Word("lutti","ten",R.drawable.number_ten));

        WordAdapter Adapter=new WordAdapter(this,words,R.color.numbersCategory);

        Log.i("NumbersActivity", "After defination of adapter");
        ListView listView =findViewById(R.id.list_number);
        listView.setAdapter(Adapter);
        Log.i("NumbersActivity", "finish");



    }

}
