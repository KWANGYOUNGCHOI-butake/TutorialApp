package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConcatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_concat);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Concat").append("\n");


        List<String> numbers =
                Arrays.asList("1", "2", "3", "4", "5");
        List<String> chars =
                Arrays.asList("a", "b", "c", "d", "e");


        sb.append("\n").append("concat").append("\n");
        Stream<String> stream1 = numbers.stream();
        Stream<String> stream2 = chars.stream();
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(s -> sb.append(s).append("\n"));

        
        tv.setText(sb.toString());
    }
}
