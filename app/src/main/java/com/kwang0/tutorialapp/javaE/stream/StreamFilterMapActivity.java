package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilterMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_filter_map);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Filter").append("\n");


        List<String> list =
                Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1", "c3");


        sb.append("\n").append("filter").append("\n");
        Stream<String> stream1 = list.stream();
        Stream<String> filtered = stream1.filter(s -> s.startsWith("c"));
        filtered.forEach(s -> sb.append(s).append("\n"));


        sb.append("\n").append("map").append("\n");
        Stream<String> stream2 = list.stream();
        stream2.map(s -> s.toUpperCase())
                .forEach(s -> sb.append(s).append("\n"));


        String[][] arrays = new String[][]{ {"a1", "a2"}, {"b1", "b2"}, {"c1", "c2", "c3"} };


        sb.append("\n").append("flatmap").append("\n");
        Stream<String[]> stream4 = Arrays.stream(arrays);
        Stream<String> stream5 = stream4.flatMap(s -> Arrays.stream(s));
        stream5.forEach(s -> sb.append(s).append("\n"));


        sb.append("\n").append("filter, map, flatmap").append("\n");
        Stream<String[]> stream6 = Arrays.stream(arrays);
        Stream<String> stream7 = stream6.flatMap(s -> Arrays.stream(s));
        stream7.filter(s-> s.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(s -> sb.append(s).append("\n"));


        tv.setText(sb.toString());
    }
}
