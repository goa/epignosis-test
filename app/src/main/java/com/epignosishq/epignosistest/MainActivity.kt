package com.epignosishq.epignosistest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.epignosis.epignosistest.R
import com.epignosishq.epignosistest.model.BoringActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var service: BoredApiService
    private lateinit var boringActivityAdapter: BoringActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerViewAdapter()

        setRetrofitService()

        getActivityFromService()
    }

    private fun setRetrofitService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        service = retrofit.create(BoredApiService::class.java)
    }

    private fun getActivityFromService() {
        service.getRandomActivity().enqueue(object : Callback<BoringActivity> {
            override fun onResponse(
                call: Call<BoringActivity>,
                response: Response<BoringActivity>
            ) {
                val activity = response.body() ?: return
                // add boringActivity to list adapter
                boringActivityAdapter.addActivity(activity)
                // fetch new boringActivity from service
                getActivityFromService()
                Log.i("", activity.toString())
            }

            override fun onFailure(call: Call<BoringActivity>, t: Throwable) {
                Log.e("", "Error")
            }
        })
    }

    private fun setRecyclerViewAdapter() {
        boringActivityAdapter = BoringActivityAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = boringActivityAdapter
        }
    }
}