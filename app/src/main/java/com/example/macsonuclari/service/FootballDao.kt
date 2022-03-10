package com.example.macsonuclari.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.macsonuclari.model.Sonuclar

@Dao
interface FootballDao {

//Data access object

    @Insert
    suspend fun insertAll(vararg  sonuclar: Sonuclar) : List<Long>


    @Query("SELECT * FROM sonuclar ")
    suspend fun getAllResults() : List<Sonuclar>

    @Query("SELECT * FROM sonuclar WHERE HomeTeam OR AwayTeam = :takimismi")
    suspend fun getChosenTeamResults(takimismi : String) : List<Sonuclar>

    @Query("DELETE FROM sonuclar")
    suspend fun deleteAllResults()

}

