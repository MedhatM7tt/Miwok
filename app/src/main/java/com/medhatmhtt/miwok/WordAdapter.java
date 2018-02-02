package com.medhatmhtt.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorResource;
    //-------------------Override getView -------------
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.mylist, parent, false);
        }

        final Word currentWord = getItem(position);
        //--------------------------------------------/
        TextView miowkView=(TextView) listItemView.findViewById(R.id.miowkWord);
        miowkView.setText(currentWord.getMiwokWord());
        //----------------------------------------/
        TextView englishView=(TextView) listItemView.findViewById(R.id.englishWord);
        englishView.setText(currentWord.getEnglishWord());
        //--------------------------------------------------//
        ImageView iconView=(ImageView) listItemView.findViewById(R.id.iconDisplay);
        if(currentWord.hasImage()){
            iconView.setVisibility(View.VISIBLE);
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setBackgroundResource(R.color.tan_background);
        }
        else{
            iconView.setVisibility(View.GONE);
        }
        //---------------------------------------------------//
        View textContainer=listItemView.findViewById(R.id.textContainer);
        textContainer.setBackgroundResource(colorResource);
        //------------------------------------------------------//
        return listItemView;
    }

    //------------Constuctors ------------------------//
    public WordAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects) {
        super(context, 0, objects);
    }
    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects,int colorResource) {
        super(context, 0, objects);
        this.colorResource=colorResource;
    }
}
