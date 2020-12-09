package com.epignosishq.epignosistest

import com.epignosishq.epignosistest.model.BoringActivity
import retrofit2.Call
import retrofit2.http.GET

/**
 * A Retrofit description of the http://www.boredapi.com HTTP API.
 */
interface BoredApiService {
    @GET("activity")
    fun getRandomActivity(): Call<BoringActivity>
}