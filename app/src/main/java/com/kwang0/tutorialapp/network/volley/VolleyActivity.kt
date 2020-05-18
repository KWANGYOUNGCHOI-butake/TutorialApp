package com.kwang0.tutorialapp.network.volley;

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.kwang0.tutorialapp.R
import com.kwang0.tutorialapp.network.NetworkActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType


public class VolleyActivity: AppCompatActivity() {

    lateinit var tv: TextView

    var postUrl = NetworkActivity.POST_URL

    val JSON = MediaType.parse("application/json; charset=utf-8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)

        tv = findViewById(R.id.reuse_scroll_tv) as TextView


        var result: String = ""
        val queue: RequestQueue = Volley.newRequestQueue(this@VolleyActivity)
        val getRequest = StringRequest(Request.Method.GET, postUrl,
                Response.Listener { response ->
                    Log.i("VolleyAct", "response : " + response)
                    result = response
                },
                Response.ErrorListener {
                    Log.e("VolleyAct", "error : Error Occured!")
                })

        val postRequest = object: StringRequest(Request.Method.POST, postUrl,
                Response.Listener { response ->
                    Log.i("VolleyAct", "response : " + response)
                    tv.text = "$result\n\n$response"
                },
                Response.ErrorListener {
                    Log.e("VolleyAct", "error : Error Occured!")
                }) {
            override fun getPriority(): Priority? {
                return Priority.LOW
            }

            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params.put("name", "kwang0")
                params.put("job", "programmer")
                return params
            }

            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String>? {
                val headers: HashMap<String, String> = HashMap()
                headers["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8"
                return headers
            }
        }

        queue.add(getRequest)
        queue.add(postRequest)

    }
}
