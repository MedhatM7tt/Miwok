package com.medhatmhtt.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordslist);
        final ArrayList<Word> words=new ArrayList<Word>();
        words.addAll(Arrays.asList(new Word("Lutti","One",R.drawable.number_one,R.raw.number_one),
                new Word("Ottiko","Two",R.drawable.number_two,R.raw.number_two),
                new Word("Tolookosu","Three",R.drawable.number_three,R.raw.number_three),
                new Word("Oyyisa","Four",R.drawable.number_four,R.raw.number_four),
                new Word("Massokka","Five",R.drawable.number_five,R.raw.number_five),
                new Word("Temmokka","Six",R.drawable.number_six,R.raw.number_six),
                new Word("Kenekaku","Seven",R.drawable.number_seven,R.raw.number_seven),
                new Word("Kawinta","Eight",R.drawable.number_eight,R.raw.number_eight),
                new Word("Wo'e","Nine",R.drawable.number_nine,R.raw.number_nine),
                new Word("Na'aacha","Ten",R.drawable.number_ten,R.raw.number_ten)
                ));
        final ListView listView=(ListView) findViewById(R.id.list);
        WordAdapter wordAdapter=new WordAdapter(this,words,R.color.category_numbers);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Word word =words.get(i);
                        releaseMediaPlayer();
                        mediaPlayer=MediaPlayer.create(NumbersActivity.this,word.getRecordResource());
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
}
