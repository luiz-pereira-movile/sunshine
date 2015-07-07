package com.movile.sunshine.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.movile.sunshine.R;
import com.movile.sunshine.component.DaggerServices;
import com.movile.sunshine.services.WeatherServices;
import com.movile.sunshine.services.model.Weather;

public class MainActivity extends Activity {

    private WeatherServices weatherServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherServices = DaggerServices.builder().build().weatherServices();

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWeather();
            }
        });

        updateWeather();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateWeather();
    }

    private void updateWeather() {

        new AsyncTask<String, Void, Weather>() {

            @Override
            protected void onPreExecute() {
                findViewById(R.id.loading).setVisibility(View.VISIBLE);
            }

            @Override
            protected Weather doInBackground(String... city) {
                return weatherServices.getCurrentWeather(city[0]);
            }

            @Override
            protected void onPostExecute(Weather weather) {
                String weatherText = weather.getCity() + ", " + weather.getCountry() + ": " + weather.getTemperature() + " C";
                ((TextView) findViewById(R.id.weather)).setText(weatherText);
                findViewById(R.id.loading).setVisibility(View.INVISIBLE);
            }
        }.execute("Campinas,BR");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
