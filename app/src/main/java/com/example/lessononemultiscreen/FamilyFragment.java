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

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {
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

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView =inflater.inflate(R.layout.activity_family,container,false);
        mAudioPlayer = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Word> wordsFamily=new ArrayList<>();

        wordsFamily.add(new Word("lutti","family father",R.drawable.family_father,R.raw.family_father));
        wordsFamily.add(new Word("lutti","family mother",R.drawable.family_mother,R.raw.family_mother));
        wordsFamily.add(new Word("lutti","family daughter",R.drawable.family_daughter,R.raw.family_daughter));
        wordsFamily.add(new Word("lutti","family son",R.drawable.family_son,R.raw.family_son));
        wordsFamily.add(new Word("lutti","family grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));
        wordsFamily.add(new Word("lutti","family grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        wordsFamily.add(new Word("lutti","family older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        wordsFamily.add(new Word("lutti","family older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        wordsFamily.add(new Word("lutti","family older brother",R.drawable.family_younger_brother,R.raw.family_older_brother));
        wordsFamily.add(new Word("lutti","family_younger_sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));


        WordAdapter AdapterFamily=new WordAdapter(getActivity(),wordsFamily,R.color.familyCategory);

        Log.i("NumbersActivity", "After definition of adapter");
        ListView listView =rootView.findViewById(R.id.list_family);
        listView.setAdapter(AdapterFamily);
        Log.i("NumbersActivity", "finish");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word=wordsFamily.get(i);
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
