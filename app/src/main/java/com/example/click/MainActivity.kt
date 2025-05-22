package com.example.click

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.click.adapter.MyPagerAdapter
import com.example.click.databinding.ActivityMainBinding
import com.example.click.databinding.ItemTabBinding
import com.example.click.models.Mypager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val list = listOf<Mypager>(
        Mypager(
            R.drawable.img,
            "Click va Paymega o’tish xizmati",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum. "
        ), Mypager(
            R.drawable.img_1,
            "Barcha operatorlar bo’yicha statistika",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
        ), Mypager(
            R.drawable.img_2,
            "Tariflarni filtrlash",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
        ), Mypager(
            R.drawable.img_4,
            "Yangi imkoniyatlar",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum."
        )
    )
    lateinit var myPagerAdapter1: MyPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.skip.setOnClickListener {
            binding.myPager.currentItem = list.lastIndex
        }
        binding.next.setOnClickListener{
            binding.myPager.currentItem++

        }


        setContentView(binding.root)
        myPagerAdapter1=MyPagerAdapter(list)
        binding.myPager.setAdapter(myPagerAdapter1)
        binding.tabid.setupWithViewPager(binding.myPager)
        tabload()
    }

    private fun tabload() {
        val tabcount = binding.tabid.tabCount
        for (i in 0 until tabcount) {
            val itemTableyautBinding = ItemTabBinding.inflate(layoutInflater)
            val tab = binding.tabid.getTabAt(i)
            tab?.customView = itemTableyautBinding.root


            if (i==0){

                itemTableyautBinding.myitab.visibility= View.VISIBLE
            }else{

                itemTableyautBinding.myitab.setImageResource(R.drawable.icon1)


            }



            binding.tabid.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val customView=tab?.customView

                    customView?.findViewById<ImageView>(R.id.myitab)?.setImageResource(R.drawable.icon2)
                    customView?.findViewById<ImageView>(R.id.myitab)?.visibility= View.VISIBLE
                    if (binding.myPager.currentItem==list.lastIndex){
                        binding.next.visibility=View.INVISIBLE
                    }



                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val customView=tab?.customView


                    customView?.findViewById<ImageView>(R.id.myitab)?.setImageResource(R.drawable.icon1)
                    if (binding.myPager.currentItem<list.lastIndex){
                        binding.next.visibility=View.VISIBLE
                    }

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })


        }
    }
}