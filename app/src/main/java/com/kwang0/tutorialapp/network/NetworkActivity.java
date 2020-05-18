package com.kwang0.tutorialapp.network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;
import com.kwang0.tutorialapp.language.LanguageActivity;
import com.kwang0.tutorialapp.network.entities.Weather;
import com.kwang0.tutorialapp.network.repository.RepositoryProvider;
import com.kwang0.tutorialapp.network.repository.WeatherRepository;

import java.util.List;

public class NetworkActivity extends AppCompatActivity implements WeatherRepository.RequestCallback {

    private TextView tv;
    private Spinner spi;
    private Button btn;

    private long startTimeMills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        RepositoryProvider.initialize(this);

        tv = (TextView) findViewById(R.id.network_tv);
        spi = (Spinner) findViewById(R.id.network_spi);
        btn = (Button) findViewById(R.id.network_btn);

        final ArrayAdapter<RepositoryProvider.Client> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, RepositoryProvider.Client.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Requesting...");
                final RepositoryProvider.Client client = (RepositoryProvider.Client) spi.getSelectedItem();
                final WeatherRepository repository = RepositoryProvider.provideWeatherRepository(client);
                assert repository != null;
                startTimeMills = System.currentTimeMillis();
                Log.d("request", "start: (" + startTimeMills + ")");
                repository.getWeather(NetworkActivity.this);
                btn.setEnabled(false);
            }
        });
    }

    @Override
    public void success(Weather weather) {
        long endTimeMillis = System.currentTimeMillis();
        Log.d("request", "success: (" + endTimeMillis + ")");
        Log.d("request", "time: (" + (endTimeMillis - startTimeMills) + ")");
        String message = "success: ";
        message += weather.toString();
        tv.setText(message);
        btn.setEnabled(true);
    }

    @Override
    public void error(Throwable throwable) {
        Log.d("request", "error: (" + System.currentTimeMillis() + ")");
        String message = "error: ";
        message += throwable.getMessage();
        tv.setText(message);
        btn.setEnabled(true);
    }
}
