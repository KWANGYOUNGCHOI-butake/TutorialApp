package com.kwang0.tutorialapp.language.kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.tutorialapp.R

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val tv : TextView = findViewById(R.id.reuse_scroll_tv)

        val sb = StringBuilder()
        sb.append("Hello Kotlin").appendln()


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
        sb.append("a1 = 10, a2 = 20, max = " + max).appendln()


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


        //수신 객체 람다 내부에서 수신 객체의 함수를 사용하지 않고 수신 객체 자신을 다시 반환 하려는 경우에 apply 사용
        sb.appendln().append("apply").appendln()
        val young = User().apply { name = "young"; age = 20 }
        sb.append("name : " + young.name + " age : " + young.age).appendln()


        //수신 객체 람다가 전달된 수신 객체를 전혀 사용 하지 않거나 수신 객체의 속성을 변경하지 않고 사용하는 경우 also 사용
        sb.appendln().append("also").appendln()
        young.also { sb.append("name : ").append(it.name).append(" age : ").append(it.age).appendln() }


        //지정된 값이 null 이 아닌 경우에 코드를 실행해야 하는 경우.
        //Nullable 객체를 다른 Nullable 객체로 변환하는 경우.
        //단일 지역 변수의 범위를 제한 하는 경우.
        sb.appendln().append("let").appendln()
        var str: String? = null
        str?.let { sb.append(str).appendln() }
        str = "let sample"
        str?.let { sb.append(str).appendln() }


        //Non-nullable (Null 이 될수 없는) 수신 객체 이고 결과가 필요하지 않은 경우에만 with 사용
        sb.appendln().append("with").appendln()
        with(young) {
            sb.append("name : ").append(name).append(" age : ").append(age).appendln()
        }


        //어떤 값을 계산할 필요가 있거나 여러개의 지역 변수의 범위를 제한하려면 run
        sb.appendln().append("run").appendln()
        young.run { sb.append("name : ").append(name).append(" age : ").append(age).appendln() }


        tv.text = sb.toString()
    }

    class User {
        var name: String? = null
        var age: Int? = null

    }
}
