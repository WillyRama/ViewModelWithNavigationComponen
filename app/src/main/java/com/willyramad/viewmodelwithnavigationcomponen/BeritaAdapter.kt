package com.willyramad.viewmodelwithnavigationcomponen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class BeritaAdapter (var listBerita : ArrayList<DataBerita>) : RecyclerView.Adapter<BeritaAdapter.ViewHolder>(){
    var onClick : ((DataBerita) -> Unit)? = null
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var penulis = view.findViewById<TextView>(R.id.NamaPenulis)
        var wartawan = view.findViewById<TextView>(R.id.Namawartawan)
        var narasumber = view.findViewById<TextView>(R.id.narasumber)
        var tanggal = view.findViewById<TextView>(R.id.tanggal)
        var gambar = view.findViewById<ImageView>(R.id.imgBerita)
        var card = view.findViewById<CardView>(R.id.cardBerita)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeritaAdapter.ViewHolder, position: Int) {
        holder.penulis.text = listBerita[position].penulis
        holder.wartawan.text = listBerita[position].wartawan
        holder.narasumber.text = listBerita[position].narasumber
        holder.tanggal.text = listBerita[position].tanggal
        holder.gambar.setImageResource(listBerita[position].img)
        holder.card.setOnClickListener {
            onClick?.invoke(listBerita[position])
        }

    }

    override fun getItemCount(): Int  = listBerita.size

    fun setDataBerita(listBerita: ArrayList<DataBerita> /* = java.util.ArrayList<com.willyramad.viewmodelwithnavigationcomponen.DataBerita> */){
        this.listBerita = listBerita
    }
}