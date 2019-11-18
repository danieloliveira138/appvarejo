package com.danieloliveira.viavarejo.view.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.danieloliveira.viavarejo.models.Imagen
import com.danieloliveira.viavarejo.view.fragments.ImageFragment

class ImagesPageAdapter(
        fragmentManager: FragmentManager,
        private val images: List<Imagen>): FragmentPagerAdapter(
            fragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) =
        ImageFragment.newInstance(images[position].url)

    override fun getCount(): Int = images.size
}