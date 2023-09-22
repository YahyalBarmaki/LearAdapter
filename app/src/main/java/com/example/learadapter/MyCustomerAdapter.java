package com.example.learadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomerAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planets;
    private Context context;

    public MyCustomerAdapter(Context context,ArrayList<Planet> planets) {
        super(context, R.layout.item,planets);
        this.planets = planets;
        this.context = context;
    }

    public class MyViewHolder{
        TextView planetName, moonCount;
        ImageView planetImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planets = getItem(position);

        MyViewHolder myViewHolder;
        final  View result;
        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView =  layoutInflater.inflate(
                    R.layout.item,
                    parent,
                    false
            );
            myViewHolder.planetName = (TextView)convertView.findViewById(R.id.title_planet);
            myViewHolder.moonCount = (TextView)convertView.findViewById(R.id.moon_count);
            myViewHolder.planetImage = (ImageView) convertView.findViewById(R.id.imageview);

            result =convertView;
            convertView.setTag(myViewHolder);
        }else {

            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImage.setImageResource(planets.getPlanetImage());

        return result;

    }
}
