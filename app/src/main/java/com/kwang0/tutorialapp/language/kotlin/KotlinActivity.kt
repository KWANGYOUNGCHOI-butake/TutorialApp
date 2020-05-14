package com.kwang0.tutorialapp.language.kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.tutorialapp.R

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val tv : TextView = findViewById(R.id.kotlin_tv)

        val sb = StringBuilder()
        sb.append("Hi, Kotlin!").appendln()


        val e0: Int = 10000
        sb.appendln().append("===").appendln()
        val e1: Int? = e0
        val e2: Int? = e0
        sb.append("e0 = 10000, e1 = e0, e2 = e0").appendln()
        sb.append(e1 === e2).appendln()

        sb.appendln().append("==").appendln()
        sb.append("e0 = 10000, e1 = e0, e2 = e0").appendln()
        sb.append(e1 == e2).appendln()


        val a1 = 10
        val a2 = 20
        val max = if(a1 > a2) a1 else a2
        sb.appendln().append("if").appendln()
        sb.append("a1 = 10, a2 = 20, max = " + max)


        val b1 = 10
        sb.appendln().append("if range").appendln()
        sb.append("b1 = 10, b1 <= 20 && b1 >= 0").appendln()
        if(b1 in 0..20) sb.append("true").appendln()
        else sb.append("false").appendln()



        val x = 0
        sb.appendln().append("when").appendln()
        sb.append("x = 0, if x = 1, else if x = 2, else x is neither 1 nor 2").appendln()
        when(x) {
            1 -> sb.append("x = 1").appendln()
            2 -> sb.append("x = 2").appendln()
            else -> sb.append("x is neither 1 nor 2").appendln()
        }


        sb.appendln().append("for increase").appendln()
        for(i in 1..3) sb.append(i).append(" ")
        sb.appendln()


        sb.appendln().append("for decrease").appendln()
        for(i in 3 downTo 1) sb.append(i).append(" ")
        sb.appendln()


        sb.appendln().append("for stemp").appendln()
        for(i in 0..6 step 2) sb.append(i).append(" ")
        sb.appendln()


        var y = 5
        sb.appendln().append("while").appendln()
        sb.append("y = 10, while y > 0 y--").appendln()
        while(y > 0) {
            sb.append(y).append(" ")
            y--
        }
        sb.appendln()



        tv.text = sb.toString()
    }
}
