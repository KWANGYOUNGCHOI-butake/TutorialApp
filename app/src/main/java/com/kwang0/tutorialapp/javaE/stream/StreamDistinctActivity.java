package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDistinctActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_distinct);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Distinct").append("\n");


        List<String> strings =
                Arrays.asList("google", "apple", "google", "apple", "samsung");


        sb.append("\n").append("distinct").append("\n");
        Stream<String> stream1 = strings.stream();
        Stream<String> stream2 = stream1.distinct();
        stream2.forEach(s -> sb.append(s).append("\n"));


        List<CustomString> customStrings =
                Arrays.asList(new CustomString("google"),new  CustomString("apple"),
                        new CustomString("google"), new CustomString("apple"), new CustomString("samsung"));


        sb.append("\n").append("distinct - custom").append("\n");
        Stream<CustomString> stream3 = customStrings.stream();
        Stream<CustomString> stream4 = stream3.distinct();
        stream4.forEach(s -> sb.append(s).append("\n"));

        tv.setText(sb.toString());
    }

    private static class CustomString {
        public String str;

        public CustomString(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof CustomString) {
                return str.equals(((CustomString) o).str);
            }
            return false;
        }
    }
}
