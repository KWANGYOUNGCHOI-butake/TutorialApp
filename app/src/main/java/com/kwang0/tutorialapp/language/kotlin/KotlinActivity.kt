package com.kwang0.tutorialapp.language.kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.tutorialapp.R

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val tv : TextView = findViewById(R.id.kotlin_tv);

        val sb = StringBuilder();
        sb.append("Hi,Kotlin!").appendln();

        tv.text = sb.toString()
    }
}
