package com.example.click.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.click.R
import com.example.click.databinding.ItemPagerBinding
import com.example.click.databinding.ItemTabBinding
import com.example.click.models.Mypager

class MyPagerAdapter(
    private val list: List<Mypager>,
    private val listener: OnPagerButtonClickListener
) : RecyclerView.Adapter<MyPagerAdapter.VH>() {

    interface OnPagerButtonClickListener {
        fun onSkipClick()
        fun onNextClick(currentPosition: Int)
    }

    inner class VH(val binding: ItemPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = list[position]
        holder.binding.titleText.text = item.title
        holder.binding.descText.text = item.descriptio

        holder.binding.skipText.setOnClickListener {
            listener.onSkipClick()
        }

        holder.binding.nextText.setOnClickListener {
            listener.onNextClick(position)
        }
    }

    override fun getItemCount(): Int = list.size
}
