package com.example.macsonuclari.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Insert
import com.example.macsonuclari.R
import com.example.macsonuclari.view.sonuclarFragment
import com.example.macsonuclari.view.takimFragment
import com.example.macsonuclari.viewModel.SonuclarViewModel
import kotlinx.android.synthetic.main.takimlar_recycler_row.view.*

private val logoResimListesi = arrayListOf<Int>(R.drawable.fenerbahce,R.drawable.adanaspor,R.drawable.galatasaray,R.drawable.alanyaspor,R.drawable.trabzonspor,R.drawable.konyaspor,R.drawable.besiktas,R.drawable.hatayspor,
        R.drawable.basaksehir,R.drawable.gaziantepfk,R.drawable.sivasspor,R.drawable.kayserispor,R.drawable.fatihkaragumruk,R.drawable.kasimpasa,R.drawable.goztepe,R.drawable.giresun,R.drawable.antalyaspor,R.drawable.rizespor,R.drawable.altay,R.drawable.malatyaspor)

private var isimListesi = arrayListOf<String>("Fenerbahçe","Adana Demirspor","Galatasaray","Alanyaspor","Trabzonspor","Konyaspor","Besiktas","Atakas Hatayspor","Basaksehir","Gaziantep Futbol Kulübü","Sivasspor","Kayserispor","Fatih Karagümrük","Kasimpasa","Göztepe","Giresunspor","Antalyaspor","Çaykur Rizespor","Altay","Yeni Malatyaspor")

//@AndroidEntryPoint
class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {


    //lateinit var sonuclarViewModel :  SonuclarViewModel
    //lateinit var testString: String



    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.takimlar_recycler_row,parent,false)
        return ViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


            holder.itemView.recycler_view_TextView.text = isimListesi[position]
            holder.itemView.recycler_view_ImageView.setImageResource(logoResimListesi[position])

        holder.itemView.setOnClickListener {
            var takimismi = isimListesi[position]


           //sonuclarViewModel.refreshDataChosenTeam(takimismi)


        }

    }

    override fun getItemCount(): Int {
        return logoResimListesi.size
    }




}