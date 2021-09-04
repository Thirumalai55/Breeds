package com.changers.breeds.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.changers.breeds.BreedsApplication
import com.changers.breeds.R
import com.changers.breeds.data.model.Breeds
import com.changers.breeds.utils.Utils
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class BreedsFragment : Fragment() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    private lateinit var mViewModel: BreedsFragmentViewModel
    private lateinit var mBreedImageAdapter: BreedsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_breeds_list, container, false)
        BreedsApplication.mAppComponent.inject(this)
        mViewModel = ViewModelProvider(this, mViewModelFactory).get(BreedsFragmentViewModel::class.java)
        val value: MutableList<Breeds> = mutableListOf()
        mBreedImageAdapter = BreedsRecyclerViewAdapter(emptyList())
        value.add(Breeds(0, getString(R.string.spinner_default_value)))
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, value)
        val recyclerView: RecyclerView = view.findViewById(R.id.list)
        val spinner: Spinner = view.findViewById(R.id.spinner_breeds);
            spinner.adapter = spinnerAdapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                   val selectedItem = parent?.adapter?.getItem(position) as Breeds
                    if(selectedItem.id > 0)
                        getSelectedBreedList(selectedItem.id)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        // Set the adapter
        if (recyclerView is RecyclerView) {
            with(recyclerView) {
                layoutManager = GridLayoutManager(context, 3)
                adapter = mBreedImageAdapter
                addItemDecoration(SpacesItemDecoration(2))
            }
        }
        /*
        * Call as default in order to get breeds list
        * */
        if(Utils().isNetworkConnected()) {
            Utils().showProgressDialog(requireContext())
            //Get the breeds list from remote
            mViewModel.getBreedList().observe(viewLifecycleOwner, Observer {
                Utils().cancelProgressDialog()
                if (it != null) {
                    spinnerAdapter.addAll(it)
                    spinnerAdapter.notifyDataSetChanged()
                }
            })
        } else {
            showToastMsg()
        }
        return view
    }

    /* Get the list of images by selected breeds id
    * */
    private fun getSelectedBreedList(id: Int) {
        if(Utils().isNetworkConnected()) {
            Utils().showProgressDialog(requireContext())
            mViewModel.getSelectedBreedList(id).observe(viewLifecycleOwner, Observer {
                Utils().cancelProgressDialog()
                if (it != null)
                    mBreedImageAdapter.updateItems(it)
            })
        } else {
            showToastMsg()
        }
    }

    /* Show un available network toast
    * */
    private fun showToastMsg() {
        Toast.makeText(requireContext(), "Please check your internet connection!", Toast.LENGTH_LONG).show()
    }

    /*
    * Create fragment instance by factory method
    * */
    companion object {
        @JvmStatic
        fun newInstance() = BreedsFragment()
    }
}