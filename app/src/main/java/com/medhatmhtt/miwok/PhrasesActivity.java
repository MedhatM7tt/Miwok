package com.medhatmhtt.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordslist);
        final ArrayList<Word> words=new ArrayList<Word>();
        words.addAll(Arrays.asList(new Word("minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going),
                new Word("tinnә oyaase'nә","What is your name?",R.raw.phrase_what_is_your_name),
                new Word("oyaaset...","My name is...",R.raw.phrase_my_name_is),
                new Word("michәksәs?","How are you feeling?",R.raw.phrase_how_are_you_feeling),
                new Word("kuchi achit","I’m feeling good.",R.raw.phrase_im_feeling_good),
                new Word("әәnәs'aa?","Are you coming?",R.raw.phrase_are_you_coming),
                new Word("hәә’ әәnәm","Yes, I’m coming.",R.raw.phrase_yes_im_coming),
                new Word("әәnәm","I’m coming.",R.raw.phrase_im_coming),
                new Word("yoowutis","Let’s go.",R.raw.phrase_lets_go),
                new Word("әnni'nem","Come here.",R.raw.phrase_come_here)
        ));
        ListView listView=(ListView) findViewById(R.id.list);
        WordAdapter wordAdapter=new WordAdapter(this,words,R.color.category_phrases);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Word word =words.get(i);
                        releaseMediaPlayer();
                        mediaPlayer= MediaPlayer.create(PhrasesActivity.this,word.getRecordResource());
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                releaseMediaPlayer();
                            }
                        });
                    }
                }
        );
    }
    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
