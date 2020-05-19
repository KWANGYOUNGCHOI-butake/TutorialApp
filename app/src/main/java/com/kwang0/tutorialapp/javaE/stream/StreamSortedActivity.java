package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSortedActivity extends AppCompatActivity {
    public static final String TAG = StreamSortedActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_sorted);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Sorted").append("\n");


        List<String> langs =
                Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");


        sb.append("\n").append("sort").append("\n");
        langs.stream().sorted()
                .forEach(s -> sb.append("sorted : ").append(s).append("\n"));

        sb.append("\n").append("sort - reverse").append("\n");
        langs.stream().sorted(Comparator.reverseOrder())
                .forEach(s -> sb.append("reversed : ").append(s).append("\n"));


        sb.append("\n").append("sort - length").append("\n");
        langs.stream().sorted(Comparator.comparing(String::length))
//                .thenComparing((s1, s2) -> s2.compareToIgnoreCase(s1)))
                .forEach(s -> sb.append("sorted : ").append(s).append("\n"));

        sb.append("\n").append("sort - length reverse").append("\n");
        langs.stream().sorted(Comparator.comparing(String::length).reversed())
                .forEach(s -> sb.append("reversed : ").append(s).append("\n"));


        sb.append("\n").append("sort - length2").append("\n");
        Comparator<String> comp = (p1, p2) -> Integer.compare( p1.length(), p2.length());
        langs.stream().sorted(comp)
                .forEach(s -> sb.append("sorted : ").append(s).append("\n"));

        sb.append("\n").append("sort - length reverse").append("\n");
        langs.stream().sorted(comp.reversed())
                .forEach(s -> sb.append("reversed : ").append(s).append("\n"));


        sb.append("\n").append("sort - custom").append("\n");
        List<CustomString> csList = Arrays.asList(new CustomString("java"), new CustomString("kotlin"),
                new CustomString("haskell"), new CustomString("ruby"), new CustomString("javascript"));
        csList.stream().sorted()
                .forEach(cs -> sb.append("sorted : ").append(cs.getStr()).append("\n"));


        tv.setText(sb.toString());
    }

    // MyString class 정의
    private static class CustomString implements Comparable<CustomString> {
        public String str;

        public CustomString(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(CustomString o) {
            return Integer.compare(this.str.length(), o.str.length());
        }

        public String getStr() {
            return str;
        }
    }
}
