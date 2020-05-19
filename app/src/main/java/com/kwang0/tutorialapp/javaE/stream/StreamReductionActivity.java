package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReductionActivity extends AppCompatActivity {
    public static final String TAG = StreamReductionActivity.class.getSimpleName();

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
        Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum2 = numbers1.reduce(10, (x, y) -> x + y);
        sb.append("sum : ").append(sum2);


        sb.append("\n").append("sum - parallel").append("\n");
        Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum3 = numbers2.parallel().reduce(0, (x, y) -> x + y);
        sb.append("sum : ").append(sum3);


        sb.append("\n").append("sum - parallel minus").append("\n");
        Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum4= numbers3.parallel().reduce(0, (x, y) -> x - y);
        sb.append("sum : ").append(sum4);


        sb.append("\n").append("sum - parallel minus order").append("\n");
        Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum5 = numbers4.reduce(0,
                (x, y) -> x - y,
                (r1, r2) -> r1 + r2);
        sb.append("sum : ").append(sum5);


        tv.setText(sb.toString());
    }
}
