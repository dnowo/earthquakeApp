package com.example.earthquakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> places) {
        super(context,0,places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItem = convertView;

        if(listItem == null){
            listItem = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent,false);
        }

        Earthquake positionToApply = getItem(position);

        TextView scale = (TextView)listItem.findViewById(R.id.scale);
        scale.setText(positionToApply.getScale());

        TextView city = (TextView)listItem.findViewById(R.id.city);
        city.setText(positionToApply.getCityName());

        TextView data = (TextView)listItem.findViewById(R.id.data);
        data.setText(positionToApply.getData());


        return listItem;
    }
}
