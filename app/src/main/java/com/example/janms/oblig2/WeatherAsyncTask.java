package com.example.janms.oblig2;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

import static android.content.ContentValues.TAG;

public class WeatherAsyncTask extends AsyncTask<String, Integer, String[]> {
    public AsyncCallback delegate = null;
    private String key = "";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String[] doInBackground(String... params) {

        String[] result;



        try {
            String query = params[0];
            String unit = params[1];

            String wUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + query + "&units=" + unit + "&mode=xml&appid=" + key;
            String fUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + query + "&units=" + unit + "&appid=" + key;
            //default for "mode" variable is json.

            String forecast = getForecast(fUrl);
            String[] weather = getWeather(wUrl);

            result = new String[weather.length+2];

            result[0] = "success";

            int i;
            for(i = 0; i < weather.length; i++){
                result[i+1] = weather[i];
            }
            result[i+1] = forecast;

        }
        catch (Exception e){
            Log.d("Failed", "doInBackground: failed "+e.toString());
            result = new String[1];
            result[0] = "failed";
        }
        //delegate.weatherCallback(result);
        return result;
    }

    @Override
    protected void onPostExecute(String[] results) {
        super.onPostExecute(results);
        delegate.weatherCallback(results);
    }

    protected String getForecast(String url){

        HTTPhandler handler = new HTTPhandler();
        // Making a request to url and getting response
        String jsonString = handler.makeServiceCall(url);

        ForecastList.flush();
        if (jsonString != null) {
            try {
                JSONObject forecast = new JSONObject(jsonString);



                JSONArray forecasts = forecast.getJSONArray("list");

                // looping through All Contacts
                for (int i = 0; i < forecasts.length(); i++) {
                    JSONObject f = forecasts.getJSONObject(i);
                    JSONObject main = f.getJSONObject("main");
                    JSONArray jsonWeather = f.getJSONArray("weather");
                    JSONObject wind = f.getJSONObject("wind");
                    JSONObject sys = f.getJSONObject("sys");

                    double temperature = main.getDouble("temp");
                    double windSpeed = wind.getDouble("speed");
                    double direction = wind.getDouble("deg");
                    JSONObject weatherItem = jsonWeather.getJSONObject(0);
                    String weatherText = weatherItem.getString("description");
                    String jsonIcon = weatherItem.getString("icon");
                    String time = f.getString("dt_txt");
                    String[] dateTime = time.split(" ");
                    String[] dates = dateTime[0].split("-");
                    String date = dates[2]+"."+dates[1]+"."+dates[0];
                    String[] clocks = dateTime[1].split(":");
                    String clock = clocks[0]+":"+clocks[1];
                    int weatherIcon = R.drawable.clear_sky_d;

                    switch (jsonIcon) {
                        case "01d":
                            weatherIcon = R.drawable.clear_sky_d;
                            break;
                        case "02d":
                            weatherIcon = R.drawable.few_clouds_d;
                            break;
                        case "03d":
                            weatherIcon = R.drawable.scattered_clouds_d;
                            break;
                        case "04d":
                            weatherIcon = R.drawable.broken_clouds_d;
                            break;
                        case "09d":
                            weatherIcon = R.drawable.shower_rain_d;
                            break;
                        case "10d":
                            weatherIcon = R.drawable.rain_d;
                            break;
                        case "11d":
                            weatherIcon = R.drawable.thunderstorm_d;
                            break;
                        case "13d":
                            weatherIcon = R.drawable.snow_d;
                            break;
                        case "50d":
                            weatherIcon = R.drawable.mist_d;
                            break;
                        case "01n":
                            weatherIcon = R.drawable.clear_sky_n;
                            break;
                        case "02n":
                            weatherIcon = R.drawable.few_clouds_n;
                            break;
                        case "03n":
                            weatherIcon = R.drawable.scattered_clouds_n;
                            break;
                        case "04n":
                            weatherIcon = R.drawable.broken_clouds_n;
                            break;
                        case "09n":
                            weatherIcon = R.drawable.shower_rain_n;
                            break;
                        case "10n":
                            weatherIcon = R.drawable.rain_n;
                            break;
                        case "11n":
                            weatherIcon = R.drawable.thunderstorm_n;
                            break;
                        case "13n":
                            weatherIcon = R.drawable.snow_n;
                            break;
                        case "50n":
                            weatherIcon = R.drawable.mist_n;
                            break;
                    }
                    ForecastList.add(new ForecastItem(clock, date, temperature, windSpeed, direction, weatherText, weatherIcon));
                }
            }
            catch (final JSONException e) {
                Log.e("ErrorParsing", "Json parsing error: " + e.getMessage());

            }

        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }

        return jsonString;
    }

    protected String[] getWeather(String url){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        ResponseEntity<Current> responseEntity = restTemplate.exchange
                (url, HttpMethod.GET,null, Current.class);
        Current current = responseEntity.getBody();
        String[] data = new String[8];
        data[0] = current.getCity().getName();
        data[1] = Float.toString(current.getTemperature().getValue());
        data[2] = Float.toString(current.getWind().getSpeed().getValue());
        data[3] = current.getWind().getSpeed().getName();
        data[4] = Float.toString(current.getWind().getDirection().getValue());
        data[5] = current.getWind().getDirection().getName();
        data[6] = current.getWeather().getValue();
        data[7] = current.getWeather().getIcon();

        return data;
    }
}
