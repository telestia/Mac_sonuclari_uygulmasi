package com.example.macsonuclari.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.macsonuclari.R
import kotlinx.android.synthetic.main.fragment_mac_detay.*

class macDetayFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mac_detay, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            val arguman = macDetayFragmentArgs.fromBundle(it)




            DetailHomeTeamNameText.text = macDetayFragmentArgs.fromBundle(it).homeTeamName
            DetailAwayTeamNameText.text = arguman.awayTeamName
            DetailTakvimText.text = arguman.tarih?.take(16)
            stadyumText.text = arguman.stadyum
            DetailHomeTeamDetailResultText.text = arguman.homeTeamResult.toString()
            DetailAwayTeamDetailResultText.text = arguman.awayTeamResult.toString()

            when (arguman.homeTeamName) {
                "Yeni Malatyaspor" -> DetailHomeTeamImage.setImageResource(R.drawable.malatyaspor)
                "Adana Demirspor" -> DetailHomeTeamImage.setImageResource(R.drawable.adanaspor)
                "Basaksehir" -> DetailHomeTeamImage.setImageResource(R.drawable.basaksehir)
                "Atakas Hatayspor" -> DetailHomeTeamImage.setImageResource(R.drawable.hatayspor)
                "Kasimpasa" -> DetailHomeTeamImage.setImageResource(R.drawable.kasimpasa)
                "Altay" -> DetailHomeTeamImage.setImageResource(R.drawable.altay)
                "Antalyaspor" -> DetailHomeTeamImage.setImageResource(R.drawable.antalyaspor)
                "Giresunspor" -> DetailHomeTeamImage.setImageResource(R.drawable.giresun)
                "Galatasaray" -> DetailHomeTeamImage.setImageResource(R.drawable.galatasaray)
                "Sivasspor" -> DetailHomeTeamImage.setImageResource(R.drawable.sivasspor)
                "Besiktas" -> DetailHomeTeamImage.setImageResource(R.drawable.besiktas)
                "Fatih Karagümrük" -> DetailHomeTeamImage.setImageResource(R.drawable.fatihkaragumruk)
                "Fenerbahçe" -> DetailHomeTeamImage.setImageResource(R.drawable.fenerbahce)
                "Göztepe" -> DetailHomeTeamImage.setImageResource(R.drawable.goztepe)
                "Çaykur Rizespor" ->DetailHomeTeamImage.setImageResource(R.drawable.rizespor)
                "Kayserispor" -> DetailHomeTeamImage.setImageResource(R.drawable.kayserispor)
                "Konyaspor" -> DetailHomeTeamImage.setImageResource(R.drawable.konyaspor)
                "Gaziantep Futbol Kulübü" -> DetailHomeTeamImage.setImageResource(R.drawable.gaziantepfk)
                "Alanyaspor" -> DetailHomeTeamImage.setImageResource(R.drawable.alanyaspor)
                "Trabzonspor" -> DetailHomeTeamImage.setImageResource(R.drawable.trabzonspor)
            }
            when (arguman.awayTeamName) {
                "Yeni Malatyaspor" -> DetailAwayTeamImage.setImageResource(R.drawable.malatyaspor)
                "Adana Demirspor" -> DetailAwayTeamImage.setImageResource(R.drawable.adanaspor)
                "Basaksehir" -> DetailAwayTeamImage.setImageResource(R.drawable.basaksehir)
                "Atakas Hatayspor" -> DetailAwayTeamImage.setImageResource(R.drawable.hatayspor)
                "Kasimpasa" -> DetailAwayTeamImage.setImageResource(R.drawable.kasimpasa)
                "Altay" -> DetailAwayTeamImage.setImageResource(R.drawable.altay)
                "Antalyaspor" -> DetailAwayTeamImage.setImageResource(R.drawable.antalyaspor)
                "Giresunspor" -> DetailAwayTeamImage.setImageResource(R.drawable.giresun)
                "Galatasaray" -> DetailAwayTeamImage.setImageResource(R.drawable.galatasaray)
                "Sivasspor" -> DetailAwayTeamImage.setImageResource(R.drawable.sivasspor)
                "Besiktas" -> DetailAwayTeamImage.setImageResource(R.drawable.besiktas)
                "Fatih Karagümrük" -> DetailAwayTeamImage.setImageResource(R.drawable.fatihkaragumruk)
                "Fenerbahçe" -> DetailAwayTeamImage.setImageResource(R.drawable.fenerbahce)
                "Göztepe" -> DetailAwayTeamImage.setImageResource(R.drawable.goztepe)
                "Çaykur Rizespor" ->DetailAwayTeamImage.setImageResource(R.drawable.rizespor)
                "Kayserispor" -> DetailAwayTeamImage.setImageResource(R.drawable.kayserispor)
                "Konyaspor" -> DetailAwayTeamImage.setImageResource(R.drawable.konyaspor)
                "Gaziantep Futbol Kulübü" -> DetailAwayTeamImage.setImageResource(R.drawable.gaziantepfk)
                "Alanyaspor" -> DetailAwayTeamImage.setImageResource(R.drawable.alanyaspor)
                "Trabzonspor" -> DetailAwayTeamImage.setImageResource(R.drawable.trabzonspor)
            }



        }
    }


    override fun onDestroy() {
        super.onDestroy()
        val action = macDetayFragmentDirections.actionMacDetayFragment2ToBaglayiciFragment()
        view?.let {
        println("View Varmış")
            Navigation.findNavController(it).navigate(action) }
    }
}

