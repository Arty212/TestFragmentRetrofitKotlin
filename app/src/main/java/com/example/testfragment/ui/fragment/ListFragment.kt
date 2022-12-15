package com.example.testfragment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.testfragment.databinding.FragmentListBinding
import com.example.testfragment.model.Country
import com.example.testfragment.presener.ListCountriesPresenter
import com.example.testfragment.view.ListCountriesView
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class ListFragment : MvpAppCompatFragment(), ListCountriesView {

    @InjectPresenter
    lateinit var listCountriesPresenter: ListCountriesPresenter

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ArrayAdapter<Country>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArrayAdapter(
            requireActivity().applicationContext,
            android.R.layout.simple_list_item_1, ArrayList<Country>()
        )
        binding.list.adapter = adapter
        binding.list.setOnItemClickListener { _, _, i, _ ->
            //TO-DO
        }

        binding.refresh.setOnRefreshListener {
            listCountriesPresenter.loadCountries()
        }
    }

    override fun showProgress() {
        setProgress(true)
    }

    override fun ok(countries: ArrayList<Country>) {
        setProgress(false)
        adapter.clear()
        adapter.addAll(countries)
    }

    override fun error(msg: String) {
        setProgress(false)
        Snackbar
            .make(binding.root, msg, Snackbar.LENGTH_LONG)
            .show()
    }

    private fun setProgress(flag: Boolean) {
        binding.refresh.isRefreshing = flag
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListFragment()
    }
}