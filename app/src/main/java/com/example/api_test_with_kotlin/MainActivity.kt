package com.example.api_test_with_kotlin

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val url="https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        downloadTask()
    }

    private fun downloadTask() {
        val pd=ProgressDialog(this)
        pd.setMessage("downloading..")
        pd.show()
        val queue= Volley.newRequestQueue(this)
        val request=StringRequest(Request.Method.GET,url,
            Response.Listener { response ->  
                val data=response.toString()
                Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
                Log.e("data",data)
                //val jobj=JSONObject(data)
                //val jarray=jobj.getJSONArray("data")
                //for (i in 0..jarray.length()-1){
               //  val jobj2=jarray.getJSONObject(i)
               // }
            },

            Response.ErrorListener { error ->
                pd.dismiss()
                val er=error.toString()
                Log.e("error",er)
            })
        queue.add(request)
    }
}