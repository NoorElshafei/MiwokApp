package com.example.lessononemultiscreen;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PharsesActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    AudioManager mAudioPlayer;


    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                            ||focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mMediaPlayer.start();
                    }
                }
            };

    MediaPlayer.OnCompletionListener onCompletionListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharses);

        mAudioPlayer = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Word> wordsPhrases=new ArrayList<>();

        wordsPhrases.add(new Word("whare are you going","family father",R.raw.phrase_where_are_you_going));
        wordsPhrases.add(new Word("what is your name","family mother",R.raw.phrase_what_is_your_name));
        wordsPhrases.add(new Word("My name is...","family daughter",R.raw.phrase_my_name_is));
        wordsPhrases.add(new Word("How are you feeling?","family son",R.raw.phrase_how_are_you_feeling));
        wordsPhrases.add(new Word("I'm feeling good.","family grandfather",R.raw.phrase_im_feeling_good));
        wordsPhrases.add(new Word("Are you coming?","family grandmother",R.raw.phrase_are_you_coming));
        wordsPhrases.add(new Word("Yes,I'm coming?","family older brother",R.raw.phrase_yes_im_coming));
        wordsPhrases.add(new Word("I'm coming?","family older sister",R.raw.phrase_im_coming));
        wordsPhrases.add(new Word("Let's go","family older brother",R.raw.phrase_lets_go));
        wordsPhrases.add(new Word("Come here","family_younger_sister",R.raw.phrase_come_here));


        WordAdapter AdapterPhrases=new WordAdapter(this,wordsPhrases,R.color.phrasesCategory);

        Log.i("NumbersActivity", "After defination of adapter");
        ListView listView =findViewById(R.id.list_phrases);
        listView.setAdapter(AdapterPhrases);
        Log.i("NumbersActivity", "finish");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=wordsPhrases.get(i);
                mMediaPlayer = MediaPlayer.create(PharsesActivity.this,word.getSound());

                int result = mAudioPlayer.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();
        }

        mMediaPlayer=null;
        mAudioPlayer.abandonAudioFocus(afChangeListener);

    }
}
