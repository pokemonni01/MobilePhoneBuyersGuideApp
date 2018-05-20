package com.wachi.mobilephonebuyersguidapp.page.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by WachiGO on 20/5/2018 AD
 */
class PageAdapter(private val listFragment: List<Fragment>, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = listFragment[position]

    override fun getCount() = listFragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "MOBILE LIST"
            1 -> "FAVORITE LIST"
            else -> "NULL"
        }
    }
}