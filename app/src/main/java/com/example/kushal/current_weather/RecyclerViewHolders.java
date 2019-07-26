package com.example.kushal.current_weather;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewHolders extends RecyclerView.ViewHolder{
    private static final String TAG = RecyclerViewHolders.class.getSimpleName();

    public TextView dayOfWeek;

    public ImageView weatherIcon;

    public TextView weatherResultmain;

    public TextView weatherResultdesc;
    public TextView tempRange ;

    public RecyclerViewHolders(final View itemView) {
        super(itemView);
        dayOfWeek = (TextView)itemView.findViewById(R.id.day_of_week);
        weatherIcon = (ImageView)itemView.findViewById(R.id.weather_icon);
        weatherResultmain = (TextView) itemView.findViewById(R.id.weather_result);
        weatherResultdesc = (TextView)itemView.findViewById(R.id.weather_result_small);
        tempRange = (TextView) itemView.findViewById(R.id.temp_range);
    }

}
