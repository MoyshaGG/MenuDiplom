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
import com.example.diplom.databinding.ItemCpuBinding
import com.example.diplom.databinding.ItemMotherBinding
import com.example.diplom.model.CPU
import com.example.diplom.model.Motherboard


class MotherAdapter(private val onItemClick: IOnItemClick) :
    ListAdapter<Motherboard, MotherAdapter.ProfileHolder>(object : DiffUtil.ItemCallback<Motherboard>() {
        override fun areItemsTheSame(
            oldItem: Motherboard,
            newItem: Motherboard
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Motherboard,
            newItem: Motherboard
        ): Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        return ProfileHolder(ItemMotherBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class ProfileHolder(binding: ItemMotherBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nameMothertextView: TextView = binding.nameMother
        private val motherPriceTextView: TextView = binding.motherPrice
        private val motherImageView: ImageView = binding.imageMotherRecycle
        private val motherSocketTextView: TextView = binding.MotherSocket
        private val motherMemoryType: TextView = binding.MotherMemoryType
//        private val cpuCores: TextView = binding.CpuCores
//        private val cpuMemoryType: TextView = binding.CpuMemoryType
//        private val cpuSocket: TextView = binding.CpuSocket
//        private val cpuThread: TextView = binding.CpuThreads
        fun bind(item: Motherboard, context: Context) {
            nameMothertextView.text = item.motherboardName
            motherPriceTextView.text = item.motherboardPrice.toString()
            motherSocketTextView.text = item.motherboardSocket
            motherMemoryType.text = item.motherboardMaxRamMemory
//            cpuCores.text = item.cpuCores.toString()
//            cpuMemoryType.text = item.cpuMemoryType
//            cpuSocket.text = item.cpuSocket
//            cpuThread.text = item.cpuThreads.toString()


            Glide.with(context)
                .load(item.motherboardImage)
                .error(R.drawable.ic_baseline_image_24)
                .into(motherImageView)
            itemView.setOnClickListener {
                onItemClick.onClick(item.id)
            }
        }
    }
}