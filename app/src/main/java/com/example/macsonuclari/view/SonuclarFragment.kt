package com.example.macsonuclari.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.macsonuclari.R
import com.example.macsonuclari.adapter.SonuclarRecyclerViewAdapter
import com.example.macsonuclari.viewModel.SonuclarViewModel
import kotlinx.android.synthetic.main.fragment_sonuclar.*


class sonuclarFragment : Fragment() {


    private lateinit var  viewModel : SonuclarViewModel
    private var sonuclarRecyclerViewAdapter = SonuclarRecyclerViewAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sonuclar, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(SonuclarViewModel::class.java)


        sonucRecyclerView.adapter = sonuclarRecyclerViewAdapter
        sonucRecyclerView.layoutManager = LinearLayoutManager(context)



        observeLiveData()
        viewModel.refreshData()




    }

    fun observeLiveData(){
        viewModel.sonucListesi.observe(viewLifecycleOwner, Observer { results ->
            println("observeLiveData")

            results?.let {
                viewModel.progressBar.value = false
                sonuclarRecyclerViewAdapter.updateResults(it)
            }
        })

        viewModel.progressBar.observe(viewLifecycleOwner, Observer { boolean ->

            boolean?.let {

                if (it){
                    progressBar.visibility = View.VISIBLE
                }
                else{
                    progressBar.visibility = View.GONE
                }
            }

        })


    }




}