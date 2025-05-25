package com.example.click.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.click.R
import com.example.click.adapter.MyPagerAdapter
import com.example.click.databinding.FragmentSignupBinding
import com.example.click.models.Mypager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Signup : Fragment() {
    private val binding by lazy { FragmentSignupBinding.inflate(layoutInflater) }
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: MyPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewPager = binding.fragmentViewpager

        val list = listOf<Mypager>(
            Mypager(R.drawable.signup1, "We serve incomparable delicacies", "All the best restaurants with their top menu waiting for you, they cant’t wait for your order!!"),

            Mypager(R.drawable.signup2, "We serve incomparable delicacies", "All the best restaurants with their top menu waiting for you, they cant’t wait for your order!!"),

            Mypager(R.drawable.signup2, "We serve incomparable delicacies", "All the best restaurants with their top menu waiting for you, they cant’t wait for your order!!"),
        )

        adapter = MyPagerAdapter(list)
        viewPager.adapter = adapter

        return binding.root
    }
}