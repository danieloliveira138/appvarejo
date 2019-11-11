package com.danieloliveira.viavarejo.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

import com.danieloliveira.viavarejo.R
import com.danieloliveira.viavarejo.models.Produto
import com.danieloliveira.viavarejo.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(id: Int): DetailFragment {
            val fragment = DetailFragment()
            val bundle = bundleOf("Product_Id" to id)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
