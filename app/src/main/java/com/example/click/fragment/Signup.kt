package com.example.click.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.click.R
import com.example.click.adapter.MyPagerAdapter
import com.example.click.databinding.FragmentSignupBinding
import com.example.click.databinding.ItemPagerBinding
import com.example.click.databinding.ItemTabBinding
import com.example.click.models.Mypager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.compareTo

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class Signup : Fragment(), MyPagerAdapter.OnPagerButtonClickListener {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MyPagerAdapter
    private lateinit var list: List<Mypager>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        list = listOf(
            Mypager(R.drawable.signup1, "We serve \n incomparable \n delicacies", "All the best restaurants with their top \n menu waiting for you, they cant’t wait \n for your order!!"),
            Mypager(R.drawable.signup2, "We serve \n incomparable \n delicacies", "All the best restaurants with their top \n menu waiting for you, they cant’t wait \n for your order!!"),
            Mypager(R.drawable.signup2, "We serve \n incomparable \n delicacies", "All the best restaurants with their top \n menu waiting for you, they cant’t wait \n for your order!!"),
        )

        adapter = MyPagerAdapter(list, this)
        binding.fragmentViewpager.adapter = adapter

        TabLayoutMediator(binding.tabid, binding.fragmentViewpager) { _, _ -> }.attach()
        tabload()

        return binding.root
    }

    override fun onSkipClick() {
        binding.fragmentViewpager.currentItem = list.lastIndex
    }

    override fun onNextClick(currentPosition: Int) {
        if (currentPosition < list.lastIndex) {
            binding.fragmentViewpager.currentItem = currentPosition + 1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun tabload() {
        val tabCount = binding.tabid.tabCount

        for (i in 0 until tabCount) {
            val itemTabBinding = ItemTabBinding.inflate(layoutInflater)
            val tab = binding.tabid.getTabAt(i)
            tab?.customView = itemTabBinding.root

            if (i == 0) {
                itemTabBinding.myitab.setImageResource(R.drawable.icon2)
                itemTabBinding.myitab.visibility = View.VISIBLE
            } else {
                itemTabBinding.myitab.setImageResource(R.drawable.icon1)
                itemTabBinding.myitab.visibility = View.VISIBLE
            }

            // Har bir tab'ga view'ni tag qilib biriktiramiz
            tab?.tag = itemTabBinding
        }

        binding.tabid.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabBinding = tab?.tag as? ItemTabBinding ?: return
                tabBinding.myitab.setImageResource(R.drawable.icon2)

                if (binding.fragmentViewpager.currentItem == list.lastIndex) {
                    ItemPagerBinding.inflate(layoutInflater).nextText.visibility = View.INVISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabBinding = tab?.tag as? ItemTabBinding ?: return
                tabBinding.myitab.setImageResource(R.drawable.icon1)

                if (binding.fragmentViewpager.currentItem < list.lastIndex) {
                    ItemPagerBinding.inflate(layoutInflater).nextText.visibility = View.VISIBLE
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}
