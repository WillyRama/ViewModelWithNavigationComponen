package com.willyramad.viewmodelwithnavigationcomponen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ambildata()
    }
    fun ambildata(){
        val ambil = arguments?.getSerializable("detail") as DataBerita
        detailpenulis.text = ambil.penulis
        detailnarasumber.text = ambil.narasumber
        detailwartawan.text = ambil.wartawan
        detailtanggal.text = ambil.tanggal
        isiBerita.text = ambil.isi
        imgdetail.setImageResource(ambil.img)
    }
}