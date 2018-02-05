package com.medhatmhtt.miwok;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbers=(TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,NumbersActivity.class);
                        startActivity(intent);
                    }
                }
        );

        TextView family=(TextView) findViewById(R.id.family);
        family.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,FamilyActivity.class);
                        startActivity(intent);
                    }
                }
        );
        TextView colors=(TextView) findViewById(R.id.colors);
        colors.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,ColorsActivity.class);
                        startActivity(intent);
                    }
                }
        );
        TextView phrases=(TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,PhrasesActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}