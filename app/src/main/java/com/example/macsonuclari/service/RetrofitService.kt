package com.example.macsonuclari.service

import com.example.macsonuclari.adapter.SonuclarRecyclerViewAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {



    private var sonuclarRecyclerViewAdapter = SonuclarRecyclerViewAdapter(arrayListOf())

    val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL).build()

    val service = retrofit.create(FootballAPI::class.java)
    val call = service.getData()




}