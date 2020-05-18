package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReductionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_reduction);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Reduction").append("\n");


        sb.append("\n").append("sum").append("\n");
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Optional<Integer> sum = numbers.reduce(Integer::sum);
        Optional<Integer> sum1 = numbers.reduce((x, y) -> x + y);
        sum1.ifPresent(s -> sb.append("sum : ").append(s));
        sb.append("\n");


        sb.append("\n").append("sum - init").append("\n");
        Integer sum2 = numbers.reduce(10, (x, y) -> x + y);
        sb.append("sum : ").append(sum2);


        sb.append("\n").append("sum - parallel").append("\n");
        Integer sum3 = numbers.parallel().reduce(0, (x, y) -> x + y);
        sb.append("sum : ").append(sum3);


        sb.append("\n").append("sum - parallel minus").append("\n");
        Integer sum4= numbers.parallel().reduce(0, (x, y) -> x - y);
        sb.append("sum : ").append(sum4);


        sb.append("\n").append("sum - parallel minus order").append("\n");
        Integer sum5 = numbers.reduce(0,
                (x, y) -> x - y,
                (r1, r2) -> r1 + r2);
        sb.append("sum : ").append(sum5);


        tv.setText(sb.toString());
    }
}
