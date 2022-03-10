package com.example.macsonuclari.service

import com.example.macsonuclari.model.Sonuclar
import retrofit2.Call
import retrofit2.http.GET

val BASE_URL = "https://fixturedownload.com/"
interface FootballAPI {

    //  https://api.collectapi.com/sport/results?data.league=super-lig
    //https://fixturedownload.com/feed/json/super-lig-2021/
    @GET("feed/json/super-lig-2021/")
    fun getData() : Call<List<Sonuclar>>

}