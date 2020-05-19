package com.kwang0.tutorialapp.javaE.optional;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;


public class OptionalActivity extends AppCompatActivity {
    public static final String TAG = OptionalActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hello Optional").append("\n");


        String str = "String in Optional";
        String nullStr = null;
        Optional<String> opStr = Optional.of(str);
        Optional<String> opNullStr = Optional.ofNullable(nullStr);
        Optional<String> opEmptyStr = Optional.empty();


        sb.append("\n").append("optional").append("\n");
        sb.append("OpStr : ").append(opStr.get()).append("\n");
        try {
            sb.append("OpNullStr : ").append(opNullStr.get()).append("\n");
        } catch (NoSuchElementException e) {
            sb.append("OpNullStr : ").append("No Such Element").append("\n");
        }
        try {
            sb.append("OpEmptyStr : ").append(opEmptyStr.get()).append("\n");
        } catch (NoSuchElementException e) {
            sb.append("OpEmptyStr : ").append("No Such Element").append("\n");
        }


        sb.append("\n").append("isPresent && ifPresent").append("\n");
        if(opStr.isPresent()) sb.append("OpStr isPresent : ").append(opStr.get()).append("\n");
        if(opNullStr.isPresent()) sb.append("OpNullStr isPresent : ").append(opNullStr.get()).append("\n");
        //람다식으로 표현
        opStr.ifPresent(s -> sb.append("OpStr ifPresent : ").append(s).append("\n"));
        opNullStr.ifPresent(s -> sb.append("OpNullStr ifPresent : ").append(s).append("\n"));


        opStr = Optional.of(str);
        opNullStr = Optional.ofNullable(nullStr);
        sb.append("\n").append("orElse").append("\n");
        sb.append("OpStr orElse : ").append(opStr.orElse("new string from orElse")).append("\n");
        sb.append("OpNullStr orElse : ").append(opNullStr.orElse("new string from orElse")).append("\n");


        opStr = Optional.of(str);
        opNullStr = Optional.ofNullable(nullStr);
        sb.append("\n").append("orElseGet").append("\n");
        sb.append("OpStr orElseGet : ").append(opStr.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "new string from orElseGet";
            }
        })).append("\n");
        sb.append("OpNullStr orElseGet : ").append(opNullStr.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "new string from orElseGet";
            }
        })).append("\n");
        sb.append("OpStr orElseGet : ").append(opStr.orElseGet(() -> "new string from orElseGet")).append("\n");
        sb.append("OpNullStr orElseGet : ").append(opNullStr.orElseGet(() -> "new string from orElseGet")).append("\n");


        opStr = Optional.of(str);
        opNullStr = Optional.ofNullable(nullStr);
        sb.append("\n").append("orElseThrow").append("\n");
        try {
            sb.append("OpStr orElseThrow : ").append(opStr.orElseThrow(NullPointerException::new)).append("\n");
        } catch (NullPointerException e) {
            sb.append("NullPointerException").append("\n");
        }
        try {
            sb.append("OpNullStr orElseThrow : ").append(opNullStr.orElseThrow(NullPointerException::new)).append("\n");
        } catch (NullPointerException e) {
            sb.append("NullPointerException").append("\n");
        }


        
        Optional<String> opStr1 = Optional.of("Optional Str");
        Optional<String> opStr2 = Optional.of("Optional String");
        Optional<String> filterOpStr1 = opStr1.filter(s -> s.contains("String"));
        Optional<String> filterOpStr2 = opStr2.filter(s -> s.contains("String"));
        sb.append("\n").append("filter").append("\n");
        filterOpStr1.ifPresent(s -> sb.append("OpStr1 filter : ").append(s).append("\n"));
        filterOpStr2.ifPresent(s -> sb.append("OpStr2 filter : ").append(s).append("\n"));



        tv.setText(sb.toString());
    }
}
