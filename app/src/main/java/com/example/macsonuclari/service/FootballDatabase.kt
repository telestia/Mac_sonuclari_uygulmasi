package com.example.macsonuclari.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.macsonuclari.model.Sonuclar

@Database(entities = arrayOf(Sonuclar::class),version = 1)
abstract class FootballDatabase  : RoomDatabase(){

    abstract fun footballDao() : FootballDao

    //Singleton

    companion object{

        @Volatile private var instance : FootballDatabase? = null
        //Farklı threadlerde görünür hale getiriyor tam anlamadım

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: makeDatabase(context).also {
                instance = it
            }

        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,FootballDatabase::class.java,"footballdatabase").build()


    }
}

