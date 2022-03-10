package com.example.macsonuclari.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.macsonuclari.R
import com.example.macsonuclari.model.Sonuclar
import com.example.macsonuclari.view.BaglayiciFragmentDirections
import com.example.macsonuclari.view.sonuclarFragment.*
import kotlinx.android.synthetic.main.fragment_mac_detay.view.*
import kotlinx.android.synthetic.main.sonuc_recycler_row.view.*

class SonuclarRecyclerViewAdapter(val sonucList : ArrayList<Sonuclar>) : RecyclerView.Adapter<SonuclarRecyclerViewAdapter.SonucViewHolder>() {



    class SonucViewHolder(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SonucViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.sonuc_recycler_row,parent,false)
        return SonucViewHolder(inflater)


    }

    override fun onBindViewHolder(holder: SonucViewHolder, position: Int) {





            holder.itemView.evsahibiskorText.text =
                "${sonucList[position].HomeTeamScore.toString()} "
            holder.itemView.konukskorText.text = " ${sonucList[position].AwayTeamScore.toString()}"
            if (sonucList[position].HomeTeamScore > sonucList[position].AwayTeamScore) {

                holder.itemView.evsahibiskorText.setTextColor(Color.parseColor("#FF258303"))
                holder.itemView.konukskorText.setTextColor(Color.RED)
            } else if (sonucList[position].AwayTeamScore > sonucList[position].HomeTeamScore) {
                holder.itemView.konukskorText.setTextColor(Color.parseColor("#FF258303"))
                holder.itemView.evsahibiskorText.setTextColor(Color.RED)
            }
            holder.itemView.tarihText.text = sonucList[position].DateUtc.take(10)



            when (sonucList[position].HomeTeam) {
                "Yeni Malatyaspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.malatyaspor)
                "Adana Demirspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.adanaspor)
                "Basaksehir" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.basaksehir)
                "Atakas Hatayspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.hatayspor)
                "Kasimpasa" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.kasimpasa)
                "Altay" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.altay)
                "Antalyaspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.antalyaspor)
                "Giresunspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.giresun)
                "Galatasaray" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.galatasaray)
                "Sivasspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.sivasspor)
                "Besiktas" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.besiktas)
                "Fatih Karagümrük" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.fatihkaragumruk)
                "Fenerbahçe" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.fenerbahce)
                "Göztepe" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.goztepe)
                "Çaykur Rizespor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.rizespor)
                "Kayserispor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.kayserispor)
                "Konyaspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.konyaspor)
                "Gaziantep Futbol Kulübü" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.gaziantepfk)
                "Alanyaspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.alanyaspor)
                "Trabzonspor" -> holder.itemView.ilkTakimImageView.setImageResource(R.drawable.trabzonspor)
            }

            when (sonucList[position].AwayTeam) {

                "Yeni Malatyaspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.malatyaspor)
                "Adana Demirspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.adanaspor)
                "Basaksehir" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.basaksehir)
                "Atakas Hatayspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.hatayspor)
                "Kasimpasa" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.kasimpasa)
                "Altay" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.altay)
                "Antalyaspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.antalyaspor)
                "Giresunspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.giresun)
                "Galatasaray" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.galatasaray)
                "Sivasspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.sivasspor)
                "Besiktas" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.besiktas)
                "Fatih Karagümrük" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.fatihkaragumruk)
                "Fenerbahçe" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.fenerbahce)
                "Göztepe" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.goztepe)
                "Çaykur Rizespor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.rizespor)
                "Kayserispor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.kayserispor)
                "Konyaspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.konyaspor)
                "Gaziantep Futbol Kulübü" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.gaziantepfk)
                "Alanyaspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.alanyaspor)
                "Trabzonspor" -> holder.itemView.ikinciTakimImageView.setImageResource(R.drawable.trabzonspor)

        }
        holder.itemView.setOnClickListener{
            println(holder.itemView.ilkTakimImageView.resources)
            val action = BaglayiciFragmentDirections.actionBaglayiciFragmentToMacDetayFragment2(
                sonucList[position].HomeTeam,sonucList[position].AwayTeam,sonucList[position].HomeTeamScore,
                sonucList[position].AwayTeamScore,
                sonucList[position].Location,sonucList[position].DateUtc

            )
            Navigation.findNavController(it).navigate(action)



        }
    }

    override fun getItemCount(): Int {
        return sonucList.size
    }

    fun updateResults(list : List<Sonuclar>){
        sonucList.clear()
        sonucList.addAll(list)
        println(sonucList.size)
        notifyDataSetChanged()


    }





}