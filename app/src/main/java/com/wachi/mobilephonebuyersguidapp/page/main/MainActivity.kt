package com.wachi.mobilephonebuyersguidapp.page.main

import android.net.Uri
import android.os.Bundle
import android.view.View
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.BaseActivity
import com.wachi.mobilephonebuyersguidapp.page.main.adapter.PageAdapter
import com.wachi.mobilephonebuyersguidapp.page.mobilelist.MobileListFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity : BaseActivity(), MobileListFragment.OnMobileListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }

    private fun setView() {
        toolbar.toolbarBack.visibility = View.GONE
        val fragmentList = listOf(MobileListFragment.newInstance(), MobileListFragment.newInstance())
        pager.adapter = PageAdapter(fragmentList, supportFragmentManager)
    }

    override fun getLayout() = R.layout.activity_main

    override fun onFragmentInteraction(uri: Uri) {

    }
}
