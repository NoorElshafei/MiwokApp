package com.example.lessononemultiscreen;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NumbersActivity extends AppCompatActivity {
    ImageView playIcon;
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
        setContentView(R.layout.activity_numbers);

        mAudioPlayer = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Word>words=new ArrayList<>();

        words.add(new Word("lutti","one",R.drawable.number_one,R.raw.hamza));
        words.add(new Word("lutti","two",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("lutti","three",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("lutti","four",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("lutti","five",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("lutti","six",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("lutti","seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("lutti","eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("lutti","nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("lutti","ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter Adapter=new WordAdapter(this,words,R.color.numbersCategory);

        Log.i("NumbersActivity", "After definition of adapter");
        ListView listView =findViewById(R.id.list_number);
        listView.setAdapter(Adapter);
        Log.i("NumbersActivity", "finish");

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               releaseMediaPlayer();
               Word word=words.get(i);
               mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getSound());
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

    @Override
    protected void onPause() {
        super.onPause();
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
