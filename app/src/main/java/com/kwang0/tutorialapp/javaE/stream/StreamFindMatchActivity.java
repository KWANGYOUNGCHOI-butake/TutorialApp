package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindMatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_find_match);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Find Match").append("\n");



        sb.append("\n").append("find").append("\n");
        List<String> elements =
                Arrays.asList("a", "a1", "b", "b1", "c", "c1");
        Optional<String> firstElement = elements.stream()
                .filter(s -> s.startsWith("b")).findFirst();
        Optional<String> anyElement = elements.stream()
                .filter(s -> s.startsWith("b")).findAny();
        firstElement.ifPresent(s -> sb.append(s).append("\n"));
        anyElement.ifPresent(s -> sb.append(s).append("\n"));


        sb.append("\n").append("find - parallel").append("\n");
        firstElement = elements.stream().parallel()
                .filter(s -> s.startsWith("b")).findFirst();
        anyElement = elements.stream().parallel()
                .filter(s -> s.startsWith("b")).findAny();
        firstElement.ifPresent(s -> sb.append(s).append("\n"));
        anyElement.ifPresent(s -> sb.append(s).append("\n"));


        sb.append("\n").append("match").append("\n");
        boolean anyMatch
                = elements.stream().anyMatch(s -> s.startsWith("b"));
        sb.append("anyMatch: ").append(anyMatch ? "true" : "false").append("\n");

        boolean allMatch
                = elements.stream().allMatch(s -> s.startsWith("b"));
        sb.append("allMatch: ").append(allMatch ? "true" : "false").append("\n");

        boolean noneMatch
                = elements.stream().noneMatch(s -> s.startsWith("b"));
        sb.append("noneMatch: ").append(noneMatch ? "true" : "false").append("\n");

        
        tv.setText(sb.toString());
    }
}
