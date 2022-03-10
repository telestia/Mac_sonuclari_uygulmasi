package com.example.macsonuclari.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.macsonuclari.R
import com.example.macsonuclari.adapter.RecyclerViewAdapter
import com.example.macsonuclari.adapter.SonuclarRecyclerViewAdapter
import com.example.macsonuclari.viewModel.SonuclarViewModel
import kotlinx.android.synthetic.main.fragment_takim.*


class takimFragment : Fragment() {

    private var recyclerViewAdapter = RecyclerViewAdapter()
    private var sonuclarRecyclerViewAdapter = SonuclarRecyclerViewAdapter(arrayListOf())
    //lateinit var sonuclarViewModel : SonuclarViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_takim, container, false)
    }


    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //sonuclarViewModel = ViewModelProviders.of(this).get(SonuclarViewModel::class.java)



        TakimlarRecyclerView.layoutManager = GridLayoutManager(context,2, VERTICAL,false)
        TakimlarRecyclerView.adapter = recyclerViewAdapter






    }
}