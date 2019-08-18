package com.example.janms.oblig2;



public class ForecastItem {
    private String time;
    private String date;
    private double temperature;
    private double windSpeed;
    private double direction;
    private String weatherTxt;
    private int weatherIcon;

    public ForecastItem(String time, String weatherTxt) {
        this.time = time;
        this.weatherTxt = weatherTxt;
    }

    public ForecastItem(String time, String date, double temperature, double windSpeed, double direction, String weatherTxt, int weatherIcon) {
        this.time = time;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.direction = direction;
        this.weatherTxt = weatherTxt;
        this.weatherIcon = weatherIcon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public String getWeatherTxt() {
        return weatherTxt;
    }

    public void setWeatherTxt(String weatherTxt) {
        this.weatherTxt = weatherTxt;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }
}
