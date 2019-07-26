package com.example.kushal.current_weather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerviewAdapter extends  RecyclerView.Adapter<RecyclerViewHolders>{
    private ArrayList<Weather> fivedayWeather;


    protected Context context;

    public RecyclerviewAdapter(Context context, ArrayList<Weather> fivedayWeather) {
        this.fivedayWeather = fivedayWeather;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_daily_list, parent, false);
        viewHolder = new RecyclerViewHolders(layoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        holder.dayOfWeek.setText(fivedayWeather.get(position).getDay());
        holder.weatherResultmain.setText(fivedayWeather.get(position).getDate());
        holder.weatherResultdesc.setText(fivedayWeather.get(position).getDescription());
        holder.tempRange.setText("Min-Max:"+fivedayWeather.get(position).getTemperature());
    }

    @Override
    public int getItemCount() {
        return fivedayWeather.size();
    }

}
