package com.danieloliveira.viavarejo.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.Valore
import com.danieloliveira.viavarejo.view.holders.HolderDescriptionDetail
import com.danieloliveira.viavarejo.view.holders.IProductHolder

class DescriptionAdapter(
    private val values: List<Valore>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =  inflater.inflate(R.layout.holder_description_detail, parent, false)
        return HolderDescriptionDetail(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as IProductHolder
        holder.bind(values[position])
    }
}