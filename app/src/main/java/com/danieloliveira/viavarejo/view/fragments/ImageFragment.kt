package com.danieloliveira.viavarejo.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.danieloliveira.viavarejo.R
import kotlinx.android.synthetic.main.fragment_image.*

private const val IMAGE_URL = "param1"

class ImageFragment : BaseFragment() {
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrl = it.getString(IMAGE_URL)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load(imageUrl)
            .into(imageView)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ImageFragment().apply {
                arguments = bundleOf(IMAGE_URL to param1)
            }
    }
}
