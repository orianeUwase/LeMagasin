package com.example.magasin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_user_menu.*

class userMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_menu)
        val adapter= MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne(),"Add a lost Item")
        adapter.addFragment(fragmentTwo(),"View Lost Items")
        adapter.addFragment(FragmentThree(),"Buy")
        viewPager.adapter=adapter
        tabs.setupWithViewPager(viewPager)
    }
    class MyViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){
        private val fragmentList:MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()
        override fun getItem(p0: Int): Fragment {
            return fragmentList[p0]
        }

        override fun getCount(): Int {
            return titleList.size
        }
        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}
