package com.maktab87programs.hw_15_3.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maktab87programs.hw_15_3.data_models.TwentyImageDataModel
import com.maktab87programs.hw_15_3.data_models.TwentyImageDataModelItem
import com.maktab87programs.hw_15_3.databinding.ItemBinding

class TwentyImageAdapter(
    private val imgList: TwentyImageDataModel
    ): RecyclerView.Adapter<TwentyImageAdapter.ViewHolder>() {

    private lateinit var binding: ItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            Glide.with(binding.imageView)
                .load(imgList[position].download_url)
                .into(binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    class ViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {}
}