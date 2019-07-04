package com.example.lessononemultiscreen;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

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

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.list_item,container,false);


        mAudioPlayer = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Word> wordsColor=new ArrayList<>();

        wordsColor.add(new Word("lutti","black",R.drawable.color_black,R.raw.color_black));
        wordsColor.add(new Word("lutti","brown",R.drawable.color_brown,R.raw.color_brown));
        wordsColor.add(new Word("lutti","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        wordsColor.add(new Word("lutti","gray",R.drawable.color_gray,R.raw.color_gray));
        wordsColor.add(new Word("lutti","green",R.drawable.color_green,R.raw.color_green));
        wordsColor.add(new Word("lutti","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        wordsColor.add(new Word("lutti","red",R.drawable.color_red,R.raw.color_red));
        wordsColor.add(new Word("lutti","white",R.drawable.color_white,R.raw.color_white));


        WordAdapter AdapterColor=new WordAdapter(getActivity(),wordsColor,R.color.colorCategory);

        Log.i("NumbersActivity", "After definition of adapter");
        ListView listView =rootView.findViewById(R.id.list_color);
        listView.setAdapter(AdapterColor);
        Log.i("NumbersActivity", "finish");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word=wordsColor.get(i);
                mMediaPlayer = MediaPlayer.create(getActivity(),word.getSound());

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

        return rootView;
    }

    @Override
    public void onStop() {
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
