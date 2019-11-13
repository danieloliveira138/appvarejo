package com.danieloliveira.viavarejo.view.holders

import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira.viavarejo.models.Imagen
import com.danieloliveira.viavarejo.view.adapters.ImagesPageAdapter
import kotlinx.android.synthetic.main.view_pager_layout.view.*

class HolderProductImage(private val view: View): RecyclerView.ViewHolder(view), IProductHolder {

    override fun bind(data: Any) {
        if (data is ImageHolderData) {
            view.viewPager.apply {
                adapter = ImagesPageAdapter(
                    images = data.images,
                    fragmentManager = data.fragmentManager!!)
            }
        }
    }

    data class ImageHolderData(
        val fragmentManager: FragmentManager?,
        val images: List<Imagen>
    )
}