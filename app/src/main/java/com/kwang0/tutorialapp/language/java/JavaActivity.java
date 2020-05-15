package com.kwang0.tutorialapp.language.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hi, Java!").append("\n");

        int a1 = 10, a2 = 20;
//        int max = a1 > a2 ? a : a2;
//        int max = Math.max(a1, a2);
        int max = 0;
        if(a1 > a2) {
            max = a1;
        } else {
            max = a2;
        }
        sb.append("\n").append("if").append("\n");
        sb.append("a1 = 10, a2 = 20, max = " + max).append("\n");


        int b1 = 10;
        sb.append("\n").append("if range").append("\n");
        sb.append("b1 = 10, b1 <= 20 && b1 >= 0").append("\n");
        if(b1 >= 0 && b1 <= 20) {
            sb.append("true").append("\n");
        } else {
            sb.append("false").append("\n");
        }


        int x = 0;
        sb.append("\n").append("as like when").append("\n");
        sb.append("x = 0, if x = 1, else if x = 2, else x is neither 1 nor 2").append("\n");
        if(x == 1) {
            sb.append("x = 1").append("\n");
        } else if(x == 2) {
            sb.append("x = 2").append("\n");
        } else {
            sb.append("x is neither 1 nor 2").append("\n");
        }


        sb.append("\n").append("for increase").append("\n");
        for(int i = 1; i <= 3; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");


        sb.append("\n").append("for decrease").append("\n");
        for(int i = 3; i >= 1; i--) {
            sb.append(i).append(" ");
        }
        sb.append("\n");


        sb.append("\n").append("for stemp").append("\n");
        for(int i = 0; i <= 6; i += 2) {
            sb.append(i).append(" ");
        }
        sb.append("\n");


        int y = 5;
        sb.append("\n").append("while").append("\n");
        sb.append("y = 5, while y > 0 y--").append("\n");
        while(y > 0) {
            sb.append(y).append(" ");
            y--;
        }



        tv.setText(sb.toString());
    }
}
