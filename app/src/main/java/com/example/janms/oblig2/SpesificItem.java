package com.example.janms.oblig2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SpesificItem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spesific_item);


        Intent listintent = getIntent();
        int position = listintent.getIntExtra("ForecastItem_EXTRA",0);

        ForecastItem item = ForecastList.getForecastList().get(position);

        TextView text1 = findViewById(R.id.spesific1txt);
        TextView text4 = findViewById(R.id.spesific4txt);
        TextView temp = findViewById(R.id.spestemptxt);
        TextView speed = findViewById(R.id.spesSpeedvaltxt);
        TextView dir = findViewById(R.id.spesdirval);
        TextView weather = findViewById(R.id.spesweatherTxt);
        ImageView icon = findViewById(R.id.spesweathericon);


        text1.setText(item.getTime());
        text4.setText(item.getDate());
        temp.setText(String.format("%s°C", String.valueOf(item.getTemperature())));
        speed.setText(String.format("%sm/s", String.valueOf(item.getWindSpeed())));
        dir.setText(String.format("%s°", String.valueOf(item.getDirection())));
        icon.setImageResource(item.getWeatherIcon());
        weather.setText(item.getWeatherTxt());


        View root = text1.getRootView();
        int[] images = new int[3];
        images[0] = R.drawable.sky;
        images[2] = R.drawable.rain_drops;
        images[1] = R.drawable.vibrant;

        Random rand = new Random();
        root.setBackgroundResource(images[rand.nextInt(2)]);


    }

    protected void onClickClose(View view){
        finish();
    }
}
