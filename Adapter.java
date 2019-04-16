package com.example.Assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    java.util.List<List> weatherModelArrayList;
    String city;

    public Adapter(Context context, java.util.List<List> weatherModelArrayList,String city) {
        this.context = context;
        this.weatherModelArrayList = weatherModelArrayList;
        this.city = city;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.windSpeed.setText("Wind speed : "+weatherModelArrayList.get(i).getWind().getSpeed()+"");
        viewHolder.temp.setText("temperature : "+weatherModelArrayList.get(i).getMain().getTemp()+"");
        viewHolder.description.setText("Description : "+weatherModelArrayList.get(i).getWeather().get(0).getDescription()+"");
        viewHolder.city.setText("City : "+city);


    }

    @Override
    public int getItemCount() {
        return weatherModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView windSpeed,city,temp,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            windSpeed = itemView.findViewById(R.id.windSpeed);
            city = itemView.findViewById(R.id.city);
            temp = itemView.findViewById(R.id.temperature);
            description = itemView.findViewById(R.id.weatherDec);
        }
    }
}
