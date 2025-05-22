package com.example.click.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.click.databinding.ItemPagerBinding
import com.example.click.models.Mypager

class MyPagerAdapter(val list:List<Mypager>): PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`   }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemPagerBinding = ItemPagerBinding.inflate(LayoutInflater.from(container.context),container,false)
        itemPagerBinding.img.setImageResource(list[position].image)
        itemPagerBinding.txt1.text=list[position].title
        itemPagerBinding.txt2.text=list[position].descriptio
        container.addView(itemPagerBinding.root)
        return itemPagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}