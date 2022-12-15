package com.example.testfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_COUNTRIES = "param1"

class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var countries: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            countries = it.getStringArrayList(ARG_COUNTRIES)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: ArrayList<String>,) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_COUNTRIES, param1)
                }
            }
    }
}