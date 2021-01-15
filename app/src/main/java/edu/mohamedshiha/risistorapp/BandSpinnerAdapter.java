package edu.mohamedshiha.risistorapp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BandSpinnerAdapter extends ArrayAdapter<BandChart> {
    public BandSpinnerAdapter(@NonNull Context context, ArrayList<BandChart> itemsList) {
        super(context, 0,itemsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return InitView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return InitView(position, convertView, parent);
    }


    private View InitView(int pos,View convertView,ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
              R.layout.bandchart_spinner_item,parent,false
            );
        }

        ImageView  backgroundColourImage = convertView.findViewById(R.id.Image_Background_SpinnerItem);
        TextView TV_colourName = convertView.findViewById(R.id.TV_SpinnerItem_ColourName);
        TextView TV_colourValue = convertView.findViewById(R.id.TV_SpinnerItem_ColourValue);

        BandChart item = getItem(pos);

        backgroundColourImage.setBackgroundColor(Color.parseColor(item.getColourHex()));
        TV_colourName.setText(item.name());
        TV_colourValue.setText(" - "+item.getValue());
        if(item.name().contains("White")) {
            TV_colourName.setTextColor(Color.BLACK);
            TV_colourValue.setTextColor(Color.BLACK);
        }
        return convertView;
    }
}


