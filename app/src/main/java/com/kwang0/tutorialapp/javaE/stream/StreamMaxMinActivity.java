package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMaxMinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_max_min);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Max Min").append("\n");


        List<String> langs =
                Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");

        sb.append("\n").append("max").append("\n");
        //String::compareToIgnoreCase
        final Comparator<String> comp1 = (s1, s2) -> s1.compareToIgnoreCase(s2);
        Optional<String> lastOne = langs.stream().max(comp1);
        if (lastOne.isPresent()) {
            sb.append("last one: ").append(lastOne.get()).append("\n");
        }

        sb.append("\n").append("min").append("\n");
        Optional<String> firstOne = langs.stream().min(String::compareToIgnoreCase);
        firstOne.ifPresent(s -> sb.append(s).append("\n"));


        sb.append("\n").append("max - length").append("\n");
        final Comparator<String> comp2 = (p1, p2) -> Integer.compare( p1.length(), p2.length());
        Optional<String> largest = langs.stream().max(comp2);
        largest.ifPresent(s ->
                sb.append("largest: ").append(s).append("\n"));

        sb.append("\n").append("min - length").append("\n");
        Optional<String> shortest = langs.stream().min(comp2);
        shortest.ifPresent(s ->
                sb.append("shortest: ").append(s).append("\n"));



        tv.setText(sb.toString());
    }
}
