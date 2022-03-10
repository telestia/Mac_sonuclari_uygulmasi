package com.example.macsonuclari.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.macsonuclari.R
import com.example.macsonuclari.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_baglayici.*


class BaglayiciFragment : Fragment() {


    var tabTitle = arrayOf("Takimlar","Sonuclar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_baglayici, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var tl = tabLayout
        var pager = viewPager2

        pager.adapter = ViewPagerAdapter(childFragmentManager,lifecycle)


        TabLayoutMediator(tl,pager){
                tab,position ->
            tab.text = tabTitle[position]
        }.attach()








    }


}