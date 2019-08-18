package com.example.janms.oblig2;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;


public class ResultActivity extends Activity implements AsyncCallback {

    WeatherAsyncTask newAsync;
    private Bundle savedInstanceState;

    private String unit = "metric";
    private String query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = findViewById(R.id.searchRes);
        // Assumes current activity is the searchable activity
        searchView.setFocusable(true);// searchView is null
        searchView.setFocusableInTouchMode(true);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        // Do not iconify the widget; expand it by default


        JSONArray jA = new JSONArray();
        JSONObject jO = new JSONObject();
        try {
            jO.put("string", "string");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jA.put(jO);
        try {
            JSONObject jOb = jA.getJSONObject(0);
            String st = jOb.getString("string");
            Log.d("JSONTest", "onCreate: "+st);
        }
        catch (JSONException jE){

        }


    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.cont, new CurrentFragment())
                    .commit();
        }

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);

            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SearchSuggestion.AUTHORITY, SearchSuggestion.MODE);
            suggestions.saveRecentQuery(query, null);


            //https://api.openweathermap.org/data/2.5/weather?q=mo+i+rana&units=metric&mode=xml&appid=cd80f2d1b6383917cd976472ab860530
        }

        newAsync = new WeatherAsyncTask();
        newAsync.delegate = this;
        newAsync.execute(query, unit);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        try {
            super.onConfigurationChanged(newConfig);
            if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // land
            } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                // port
            }
        } catch (Exception ex) {
        }
    }



        @Override
    public void weatherCallback(String[] results) {

        TextView name = findViewById(R.id.citynametxt);
        TextView temp = findViewById(R.id.temptxt);
        TextView speedval = findViewById(R.id.speedvaltxt);
        TextView speedname = findViewById(R.id.speednametxt);
        TextView dirval = findViewById(R.id.dirvaltxt);
        TextView dirname = findViewById(R.id.dirnametxt);
        TextView weather = findViewById(R.id.weatherTxt);
        ImageView icon = findViewById(R.id.weathericon);

        if(results[0].equals("success")) {


            name.setText(results[1]);
            temp.setText(String.format("%s°C", results[2]));
            speedval.setText(String.format("%sm/s", results[3]));
            speedname.setText(results[4]);
            dirval.setText(String.format("%s°", results[5]));
            dirname.setText(results[6]);
            weather.setText(results[7]);
            Log.d("weather icon", "weatherCallback: " + results[6]);
            switch (results[8]) {
                case "01d":
                    icon.setImageResource(R.drawable.clear_sky_d);
                    break;
                case "02d":
                    icon.setImageResource(R.drawable.few_clouds_d);
                    break;
                case "03d":
                    icon.setImageResource(R.drawable.scattered_clouds_d);
                    break;
                case "04d":
                    icon.setImageResource(R.drawable.broken_clouds_d);
                    break;
                case "09d":
                    icon.setImageResource(R.drawable.shower_rain_d);
                    break;
                case "10d":
                    icon.setImageResource(R.drawable.rain_d);
                    break;
                case "11d":
                    icon.setImageResource(R.drawable.thunderstorm_d);
                    break;
                case "13d":
                    icon.setImageResource(R.drawable.snow_d);
                    break;
                case "50d":
                    icon.setImageResource(R.drawable.mist_d);
                    break;
                case "01n":
                    icon.setImageResource(R.drawable.clear_sky_n);
                    break;
                case "02n":
                    icon.setImageResource(R.drawable.few_clouds_n);
                    break;
                case "03n":
                    icon.setImageResource(R.drawable.scattered_clouds_n);
                    break;
                case "04n":
                    icon.setImageResource(R.drawable.broken_clouds_n);
                    break;
                case "09n":
                    icon.setImageResource(R.drawable.shower_rain_n);
                    break;
                case "10n":
                    icon.setImageResource(R.drawable.rain_n);
                    break;
                case "11n":
                    icon.setImageResource(R.drawable.thunderstorm_n);
                    break;
                case "13n":
                    icon.setImageResource(R.drawable.snow_n);
                    break;
                case "50n":
                    icon.setImageResource(R.drawable.mist_n);
                    break;
            }

        }
        else{

            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.cont, new ErrorFragment())
                        .commit();
            }
        }
        ListView listView = findViewById(R.id.forecastList);
        ListAdapter adapter = new ListAdapter(this, R.layout.list_item, ForecastList.getForecastList());
        listView.setAdapter(adapter);

    }

    public void onClickClear(View view){
        SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                SearchSuggestion.AUTHORITY, SearchSuggestion.MODE);
        suggestions.clearHistory();

    }
}
