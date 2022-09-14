package com.willyramad.viewmodelwithnavigationcomponen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentController
import androidx.fragment.app.FragmentHostCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_berita.*

class BeritaFragment : Fragment() {

    lateinit var BeritaVm : BeritaViewModel
    lateinit var adapterBerita : BeritaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Beritadata(view)

        BeritaVm = ViewModelProvider(this).get(BeritaViewModel::class.java)
        BeritaVm.getBerita()
        BeritaVm.Beritalist.observe(viewLifecycleOwner, Observer { adapterBerita.setDataBerita(it as ArrayList<DataBerita> /* = java.util.ArrayList<com.willyramad.viewmodelwithnavigationcomponen.DataBerita> */)
        })
    }

    fun Beritadata(view: View){

        adapterBerita = BeritaAdapter(ArrayList())
        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        tvberita.layoutManager = lm
        tvberita.adapter = adapterBerita

        adapterBerita.onClick = {
            var bundle = Bundle()
            bundle.putSerializable("detail",it)
            Navigation.findNavController(view).navigate(R.id.action_beritaFragment2_to_detailFragment, bundle)
        }
    }
}