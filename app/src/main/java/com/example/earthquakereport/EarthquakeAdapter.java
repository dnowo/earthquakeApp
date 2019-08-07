package com.example.earthquakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

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
        String primaryLocation;
        String locationOffset;

        Earthquake positionToApply = getItem(position);
        String originalLocation = positionToApply.getCityName();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }


        TextView scale = (TextView)listItem.findViewById(R.id.scale);
        String formattedMagnitude = formatMagnitude(positionToApply.getScale());
        scale.setText(formattedMagnitude);
        GradientDrawable magCircle = (GradientDrawable)scale.getBackground();
        int magColor = getMagColor(positionToApply.getScale());

        magCircle.setColor(magColor);

        TextView primaryLocationView = (TextView) listItem.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItem.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        TextView data = (TextView)listItem.findViewById(R.id.date);
        data.setText(positionToApply.getData());


        return listItem;
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagColor(double mag) {
        int magFloor = (int) Math.floor(mag);
        int resId;
        switch(magFloor)
        {
            case 0:
            case 1: resId = R.color.magnitude1;
            break;
            case 2: resId = R.color.magnitude2;
            case 3:
                resId = R.color.magnitude3;
                break;
            case 4:
                resId = R.color.magnitude4;
                break;
            case 5:
                resId = R.color.magnitude5;
                break;
            case 6:
                resId = R.color.magnitude6;
                break;
            case 7:
                resId = R.color.magnitude7;
                break;
            case 8:
                resId= R.color.magnitude8;
                break;
            case 9:
                resId = R.color.magnitude9;
                break;
            default:
                resId = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(), resId);
    }
}
