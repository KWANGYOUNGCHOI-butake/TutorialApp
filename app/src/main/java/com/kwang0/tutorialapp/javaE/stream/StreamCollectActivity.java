package com.kwang0.tutorialapp.javaE.stream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectActivity extends AppCompatActivity {
    public static final String TAG = StreamCollectActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_collect);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Stream Collect").append("\n");


        Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");


        sb.append("\n").append("hashset").append("\n");
        HashSet<String> fruitHashSet = fruits.collect(HashSet::new, HashSet::add, HashSet::addAll);
        for (String s : fruitHashSet) {
            sb.append(s);
        }
        sb.append("\n");


        sb.append("\n").append("set").append("\n");
        Set<String> fruitHashSet2 = fruits.collect(Collectors.toSet());
        for (String s : fruitHashSet2) {
            sb.append(s);
        }
        sb.append("\n");


        sb.append("\n").append("list").append("\n");
        List<String> fruitList = fruits.collect(Collectors.toList());
        for (String s : fruitList) {
            sb.append(s);
        }
        sb.append("\n");


        sb.append("\n").append("joining").append("\n");
        String fruitStr = fruits.collect(Collectors.joining());
        sb.append(fruitStr).append("\n");
        fruitStr = fruits.collect(Collectors.joining(", "));
        sb.append(fruitStr).append("\n");


        sb.append("\n").append("max").append("\n");
        Function<String, Integer> getCount = fruit-> fruit.length();
        Optional<String> resultMax = fruits.map(Object::toString).collect(Collectors.maxBy(Comparator.comparing(getCount)));
        sb.append("result: ").append(resultMax.orElse("no item")).append("\n");


        sb.append("\n").append("average").append("\n");
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double resultAvr = list.stream().collect(Collectors.averagingInt(v -> v * 2));
        sb.append("Average: ").append(resultAvr).append("\n");


        sb.append("\n").append("custom").append("\n");
        Stream<Fruit> fruits2 = Stream.of(new Fruit("1", "banana"), new Fruit("2", "apple"),
                new Fruit("3", "mango"), new Fruit("4", "kiwi"),
                new Fruit("5", "peach"), new Fruit("6", "cherry"),
                new Fruit("7", "lemon"));
        Map<String, String> map = fruits2.collect(Collectors.toMap(Fruit::getId, Fruit::getName));
        for (String key : map.keySet()) {
            sb.append("key : ").append(key).append(" value : ").append(map.get(key)).append("\n");
        }


        sb.append("\n").append("custom - repeat").append("\n");
        map = fruits2.collect(
                //item -> item.getId() = Fruit::getId
                Collectors.toMap(item -> item.getId(), item -> item.getName(),
                        (existFruit, newFruit) -> existFruit + ", " + newFruit));
        for (String key : map.keySet()) {
            sb.append("key: ").append(key).append(", value: ").append(map.get(key)).append("\n");
        }

        tv.setText(sb.toString());
    }

    static class Fruit {
        public String id;
        public String name;

        Fruit(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }
}
