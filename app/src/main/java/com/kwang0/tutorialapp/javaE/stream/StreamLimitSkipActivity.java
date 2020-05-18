package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLimitSkipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_limit_skip);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Limit Skip").append("\n");


        List<String> list =
                Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10" );


        sb.append("\n").append("limit").append("\n");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.limit(5);
        stream2.forEach(s -> sb.append(s).append("\n"));


        sb.append("\n").append("limit - random").append("\n");
        Stream<Double> randoms = Stream.generate(Math::random).limit(5);
        randoms.forEach(s -> sb.append(s).append("\n"));


        sb.append("\n").append("skip").append("\n");
        Stream<String> stream3 = list.stream();
        Stream<String> stream4 = stream3.skip(5);
        stream4.forEach(s -> sb.append(s).append("\n"));


        tv.setText(sb.toString());
    }
}
