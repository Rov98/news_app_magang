package com.example.news_app_magang

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://simple-node-app-nkd.herokuapp.com"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()

interface Api_service {
    @GET(".")
    fun getAllData(): Call<List<News>>
}

object Api {
    val retrofitService: Api_service by lazy { retrofit.create(Api_service::class.java) }
}