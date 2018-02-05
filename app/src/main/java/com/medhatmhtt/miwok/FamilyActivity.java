package com.medhatmhtt.miwok;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener= new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK||i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(i==AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            }
            else if(i==AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordslist);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.addAll(Arrays.asList(new Word("әpә", "Father", R.drawable.family_father, R.raw.family_father),
                new Word("әṭa", "Mother", R.drawable.family_mother, R.raw.family_mother),
                new Word("angsi", "Son", R.drawable.family_son, R.raw.family_son),
                new Word("tune", "Daughter", R.drawable.family_daughter, R.raw.family_daughter),
                new Word("taachi", "Older Brother", R.drawable.family_older_brother, R.raw.family_older_brother),
                new Word("chalitti", "Younger Brother", R.drawable.family_younger_brother, R.raw.family_younger_brother),
                new Word("teṭe", "Older Sister", R.drawable.family_older_sister, R.raw.family_older_sister),
                new Word("kolliti", "Younger Sister", R.drawable.family_younger_sister, R.raw.family_younger_sister),
                new Word("ama", "Grandmother", R.drawable.family_grandmother, R.raw.family_grandmother),
                new Word("paapa", "Grandfather", R.drawable.family_grandfather, R.raw.family_grandfather)
        ));
        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        ListView listView = (ListView) findViewById(R.id.list);
        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_family);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Word word = words.get(i);
                        releaseMediaPlayer();
                        int result= audioManager.requestAudioFocus(onAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                        if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                        mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getRecordResource());
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                releaseMediaPlayer();
                                }
                            }
                        );
                        }
                    }
                }
        );
    }
    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
