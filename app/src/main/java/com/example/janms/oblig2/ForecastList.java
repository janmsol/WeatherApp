package com.example.janms.oblig2;

import java.util.ArrayList;

public class ForecastList {
    private static ArrayList<ForecastItem> forecastList = new java.util.ArrayList<>();

    public static ArrayList<ForecastItem> getForecastList() {
        return forecastList;
    }

    public static void add(ForecastItem item){
        forecastList.add(item);
    }

    public static void flush(){
        forecastList = new java.util.ArrayList<>();
    }
}
