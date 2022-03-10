package com.example.macsonuclari.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.macsonuclari.CustomSharedPreferences
import com.example.macsonuclari.service.RetrofitService
import com.example.macsonuclari.model.Sonuclar
import com.example.macsonuclari.service.FootballDatabase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

var takimIcinListe : List<Sonuclar>? = null
class SonuclarViewModel

    constructor(application: Application) : BaseViewModel(application) {

    private var secilmisTakimMaclariListesi = ArrayList<Sonuclar>(100)
    private val ApiService = RetrofitService()
    private var customPreferences = CustomSharedPreferences(getApplication())
    private var refreshTime = 10 * 60 * 1000 * 1000 * 1000L

    var sonucListesi = MutableLiveData<List<Sonuclar>>()
    var progressBar = MutableLiveData<Boolean>()


    fun refreshData(){
        val updateTime = customPreferences.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime){
            getDataFromSQLite()
        }
        else{
            refreshDataFromAPI()
        }

    }
    fun getDataFromSQLite(){
        launch {
            val results = FootballDatabase(getApplication()).footballDao().getAllResults()
            showResults(results)
            Toast.makeText(getApplication(),"SQLite kullanıldı",Toast.LENGTH_LONG).show()

        }
    }
    fun refreshDataFromAPI(){
        progressBar.value = true



        ApiService.call.enqueue(object : Callback<List<Sonuclar>>{
            override fun onResponse(
                call: Call<List<Sonuclar>>,
                response: Response<List<Sonuclar>>) {


                response.body()?.let {
                    storeInSQLite(it)
                    Toast.makeText(getApplication(),"API kullanıldı",Toast.LENGTH_LONG).show()


                }
            }
            override fun onFailure(call: Call<List<Sonuclar>>, t: Throwable) {
                println("veri çekilemedi")
            }


        })

    }
    fun refreshDataChosenTeam(takimismi : String){
        var position = 0
        while (position < 380){
            takimIcinListe?.let { sonuclar ->
                if (takimismi == sonuclar[position].HomeTeam || takimismi == sonuclar[position].AwayTeam) {
                        secilmisTakimMaclariListesi.add(sonuclar[position])
                }
            }
            position++
        }
        showResults(secilmisTakimMaclariListesi)
    }
    private fun showResults(resultList : List<Sonuclar>){
        sonucListesi.value = resultList
        progressBar.value = false
        takimIcinListe = resultList
    }
    private fun storeInSQLite(resultList : List<Sonuclar>){
        launch {
            val dao  = FootballDatabase(getApplication()).footballDao()
            dao.deleteAllResults()
            val listLong = dao.insertAll(*resultList.toTypedArray())
            var i = 0
            while (i < resultList.size){
                resultList[i].uuid = listLong[i].toInt()
                i++
            }
            showResults(resultList)
        }
        customPreferences.saveTime(System.nanoTime())

    }
}