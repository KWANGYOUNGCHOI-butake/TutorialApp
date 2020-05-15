package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.HashSet;
import java.util.stream.Stream;

public class StreamCollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_collect);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();


        Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");

        
        sb.append("\n").append("hashset").append("\n");
        HashSet<String> fruitHashSet = fruits.collect(HashSet::new, HashSet::add, HashSet::addAll);
        for (String s : fruitHashSet) {
            System.out.println(s);
        }

        tv.setText(sb.toString());
    }
}
