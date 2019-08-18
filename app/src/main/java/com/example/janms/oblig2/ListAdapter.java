package com.example.janms.oblig2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends ArrayAdapter<ForecastItem> {
    private Context context;
    List<ForecastItem> ForecastList;

    public ListAdapter(Context context, int resourceId, List<ForecastItem> ForecastItemList){
        super(context, resourceId, ForecastItemList);
        this.context = context;
        this.ForecastList = ForecastItemList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(this.context);
            v = vi.inflate(R.layout.list_item, null);
        }
        ForecastItem forecastItem = this.ForecastList.get(position);
        TextView t1 = v.findViewById(R.id.item1txt);
        TextView t2 = v.findViewById(R.id.item2txt);
        TextView temp = v.findViewById(R.id.tempItemTxt);
        ImageView icon = v.findViewById(R.id.iconimg);

        t1.setText(forecastItem.getTime());
        t2.setText(forecastItem.getDate());
        temp.setText(String.format("%s°C", String.valueOf(forecastItem.getTemperature())));
        icon.setImageResource(forecastItem.getWeatherIcon());

        v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent specific = new Intent(context, SpesificItem.class);
                specific.putExtra("ForecastItem_EXTRA",position);
                context.startActivity(specific);
            }
        });


        return v;
    }

}