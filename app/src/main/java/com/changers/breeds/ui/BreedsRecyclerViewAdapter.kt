package com.changers.breeds.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SizeReadyCallback
import com.changers.breeds.R
import com.changers.breeds.data.model.SelectedBreeds
import com.changers.breeds.databinding.FragmentBreedsBinding

/** Adapter class for render the dogs images
 */
class BreedsRecyclerViewAdapter(
    private var list: List<SelectedBreeds>
) : RecyclerView.Adapter<BreedsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentBreedsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imgBreed.context)
            .load(list[position].url)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder_error)
            .into(holder.imgBreed)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(binding: FragmentBreedsBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgBreed: ImageView = binding.imgBreed
    }

    /* Update the items
    * */
    fun updateItems(updatedList: List<SelectedBreeds>) {
        list = updatedList
        notifyDataSetChanged()
    }

}