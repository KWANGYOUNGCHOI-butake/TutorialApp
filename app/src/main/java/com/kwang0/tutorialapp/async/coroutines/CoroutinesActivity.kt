package com.kwang0.tutorialapp.async.coroutines;

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.tutorialapp.ProgressDialog
import com.kwang0.tutorialapp.R
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

public class CoroutinesActivity: AppCompatActivity() {
    val TAG = CoroutinesActivity::class.java.simpleName

    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        tv = findViewById(R.id.reuse_scroll_tv) as TextView
        setTVText("Hello Couroutines!")

        openProgressDialog()
    }

    private fun setTVText(s: String) {
        tv.setText(s)
    }

    private fun openProgressDialog() {
        val pd = ProgressDialog(this)
        pd.setText("잠시만 기다려주세요...")
        pd.openProgressDialog()

        CoroutineScope(Main).launch {
            for(i in 0..9) {
                pd.setText("다운로드 진행중 : " + i * 10)
                delay(500)
            }
            pd.dismissProgressDialog()
            setTVText("Download OK!!!")
        }
    }

}
