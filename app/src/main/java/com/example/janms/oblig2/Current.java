package com.example.janms.oblig2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict= false)
public class Current {

    @Element
    private City city;

    @Element
    private Temperature temperature;

    @Element
    private Humidity humidity;

    @Element
    private Pressure pressure;

    @Element
    private Wind wind;

    @Element
    private Cloud clouds;

    @Element
    private Precip precipitation;

    @Element
    private Weather weather;

    @Element
    private Lastupdate lastupdate;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public Precip getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precip precipitation) {
        this.precipitation = precipitation;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Lastupdate getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Lastupdate lastupdate) {
        this.lastupdate = lastupdate;
    }
}
