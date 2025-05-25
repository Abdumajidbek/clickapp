package com.example.click

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.click.databinding.ActivityMainBinding
import com.example.click.fragment.Signup

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, Signup())
            .commit()
    }
}
//        binding.skip.setOnClickListener {
//            binding.myPager.currentItem = list.lastIndex
//        }
//        binding.next.setOnClickListener{
//            binding.myPager.currentItem++
//
//        }


//setContentView(binding.root)
//myPagerAdapter1=MyPagerAdapter(list)
//binding.myPager.setAdapter(myPagerAdapter1)
//binding.tabid.setupWithViewPager(binding.myPager)
//tabload()
//}

//private fun tabload() {
//    val tabcount = binding.tabid.tabCount
//    for (i in 0 until tabcount) {
//        val itemTableyautBinding = ItemTabBinding.inflate(layoutInflater)
//        val tab = binding.tabid.getTabAt(i)
//        tab?.customView = itemTableyautBinding.root
//
//
//        if (i == 0) {
//
//            itemTableyautBinding.myitab.visibility = View.VISIBLE
//        } else {
//
//            itemTableyautBinding.myitab.setImageResource(R.drawable.icon1)
//
//
//        }
//
//
//
//        binding.tabid.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                val customView = tab?.customView
//
//                customView?.findViewById<ImageView>(R.id.myitab)?.setImageResource(R.drawable.icon2)
//                customView?.findViewById<ImageView>(R.id.myitab)?.visibility = View.VISIBLE
//                if (binding.myPager.currentItem == list.lastIndex) {
//                    binding.next.visibility = View.INVISIBLE
//                }
//
//
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                val customView = tab?.customView
//
//
//                customView?.findViewById<ImageView>(R.id.myitab)?.setImageResource(R.drawable.icon1)
//                if (binding.myPager.currentItem < list.lastIndex) {
//                    binding.next.visibility = View.VISIBLE
//                }
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
//
//
//    }
//}
//}