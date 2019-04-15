package com.example.lessononemultiscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class PharsesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharses);

        ArrayList<Word> wordsPhrases=new ArrayList<>();

        wordsPhrases.add(new Word("whare are you going","family father"));
        wordsPhrases.add(new Word("what is your name","family mother"));
        wordsPhrases.add(new Word("My name is...","family daughter"));
        wordsPhrases.add(new Word("How are you feeling?","family son"));
        wordsPhrases.add(new Word("I'm feeling good.","family grandfather"));
        wordsPhrases.add(new Word("Are you coming?","family grandmother"));
        wordsPhrases.add(new Word("Yes,I'm coming?","family older brother"));
        wordsPhrases.add(new Word("I'm coming?","family older sister"));
        wordsPhrases.add(new Word("Let's go","family older brother"));
        wordsPhrases.add(new Word("Come here","family_younger_sister"));


        WordAdapter AdapterPhrases=new WordAdapter(this,wordsPhrases,R.color.phrasesCategory);

        Log.i("NumbersActivity", "After defination of adapter");
        ListView listView =findViewById(R.id.list_phrases);
        listView.setAdapter(AdapterPhrases);
        Log.i("NumbersActivity", "finish");
    }
}
