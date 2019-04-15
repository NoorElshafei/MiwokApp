package com.example.lessononemultiscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> wordsFamily=new ArrayList<>();

        wordsFamily.add(new Word("lutti","family father",R.drawable.family_father));
        wordsFamily.add(new Word("lutti","family mother",R.drawable.family_mother));
        wordsFamily.add(new Word("lutti","family daughter",R.drawable.family_daughter));
        wordsFamily.add(new Word("lutti","family son",R.drawable.family_son));
        wordsFamily.add(new Word("lutti","family grandfather",R.drawable.family_grandfather));
        wordsFamily.add(new Word("lutti","family grandmother",R.drawable.family_grandmother));
        wordsFamily.add(new Word("lutti","family older brother",R.drawable.family_older_brother));
        wordsFamily.add(new Word("lutti","family older sister",R.drawable.family_older_sister));
        wordsFamily.add(new Word("lutti","family older brother",R.drawable.family_younger_brother));
        wordsFamily.add(new Word("lutti","family_younger_sister",R.drawable.family_younger_sister));


        WordAdapter AdapterFamily=new WordAdapter(this,wordsFamily,R.color.familyCategory);

        Log.i("NumbersActivity", "After definition of adapter");
        ListView listView =findViewById(R.id.list_family);
        listView.setAdapter(AdapterFamily);
        Log.i("NumbersActivity", "finish");
    }
}
