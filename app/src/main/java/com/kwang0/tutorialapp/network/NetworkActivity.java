package com.kwang0.tutorialapp.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.network.entities.User;
import com.kwang0.tutorialapp.network.repository.RepositoryProvider;
import com.kwang0.tutorialapp.network.repository.UserRepository;

public class NetworkActivity extends AppCompatActivity implements UserRepository.RequestCallback {
    public static final String TAG = NetworkActivity.class.getSimpleName();

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
                final UserRepository repository = RepositoryProvider.provideWeatherRepository(client);
                assert repository != null;
                startTimeMills = System.currentTimeMillis();
                Log.d("request", "start: (" + startTimeMills + ")");
                repository.getUser(NetworkActivity.this);
                btn.setEnabled(false);
            }
        });
    }

    @Override
    public void success(User user) {
        long endTimeMillis = System.currentTimeMillis();
        Log.d("request", "success: (" + endTimeMillis + ")");
        Log.d("request", "time: (" + (endTimeMillis - startTimeMills) + ")");
        String message = "success: (" + (endTimeMillis - startTimeMills) + ")";
        message += user.toString();
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
