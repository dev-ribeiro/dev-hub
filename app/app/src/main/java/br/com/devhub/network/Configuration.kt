package br.com.devhub.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_API_URL = "http://192.168.1.36:8080/api/";

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_API_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build();