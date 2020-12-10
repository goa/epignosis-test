package com.epignosishq.epignosistest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.epignosis.epignosistest.R
import com.epignosishq.epignosistest.model.BoringActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service: BoredApiService = retrofit.create(BoredApiService::class.java)
        service.getRandomActivity().enqueue(object : Callback<BoringActivity> {
            override fun onResponse(
                call: Call<BoringActivity>,
                response: Response<BoringActivity>
            ) {
                val activity = response.body() ?: return
                Log.i("", activity.toString())
            }

            override fun onFailure(call: Call<BoringActivity>, t: Throwable) {
                Log.e("", "Error")
            }
        })
    }
}