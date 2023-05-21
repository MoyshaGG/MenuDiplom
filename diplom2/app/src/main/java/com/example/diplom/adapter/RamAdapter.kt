package com.example.diplom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diplom.R
import com.example.diplom.databinding.ItemRamBinding
import com.example.diplom.model.RamMemory

class RamAdapter(private val onItemClick: IOnItemClick) :
    ListAdapter<RamMemory, RamAdapter.ProfileHolder>(object : DiffUtil.ItemCallback<RamMemory>() {
        override fun areItemsTheSame(
            oldItem: RamMemory,
            newItem: RamMemory
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: RamMemory,
            newItem: RamMemory
        ): Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        return ProfileHolder(
            ItemRamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class ProfileHolder(binding: ItemRamBinding) : RecyclerView.ViewHolder(binding.root) {


        private val nameRamTextView: TextView = binding.nameRam
        private val ramPriceTextView: TextView = binding.ramPrice
        private val ramImageView: ImageView = binding.imageRamRecycle
        private val ramTimingTextView: TextView = binding.ramTiming
        private val ramMemoryType: TextView = binding.ramType
        private val ramFrequency: TextView = binding.ramFrequency


        fun bind(item: RamMemory, context: Context) {
            nameRamTextView.text = item.modelName
            ramPriceTextView.text = item.memoryPrice
            ramTimingTextView.text = item.timing
            ramMemoryType.text = item.typeDDR
            ramFrequency.text = item.frequency.toString()
//            cpuCores.text = item.cpuCores.toString()
//            cpuMemoryType.text = item.cpuMemoryType
//            cpuSocket.text = item.cpuSocket
//            cpuThread.text = item.cpuThreads.toString()


            Glide.with(context)
                .load(item.memoryImage)
                .error(R.drawable.ic_baseline_image_24)
                .into(ramImageView)
            itemView.setOnClickListener {
                onItemClick.onClick(item.id)
            }
        }
    }
}