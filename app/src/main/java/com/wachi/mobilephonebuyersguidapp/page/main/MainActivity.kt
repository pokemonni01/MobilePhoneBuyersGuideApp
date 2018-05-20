package com.wachi.mobilephonebuyersguidapp.page.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.BaseActivity
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import com.wachi.mobilephonebuyersguidapp.page.favoritelist.FavoriteListFragment
import com.wachi.mobilephonebuyersguidapp.page.main.adapter.PageAdapter
import com.wachi.mobilephonebuyersguidapp.page.main.sortingdialog.SortingDialogFragment
import com.wachi.mobilephonebuyersguidapp.page.mobiledetail.MobileDetailActivity
import com.wachi.mobilephonebuyersguidapp.page.mobilelist.MobileListFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity : BaseActivity(), MobileListFragment.OnMobileListFragmentInteractionListener, FavoriteListFragment.OnFavoriteListFragmentInteractionListener, SortingDialogFragment.SortingDialogListener {

    companion object {
        const val MOBILE_ITEM_KEY = "mobile_item"
    }

    private val mMobileListSortingDialog = SortingDialogFragment.newInstance()

    private val mobileListFragment = MobileListFragment.newInstance()
    private val favoriteListFragment = FavoriteListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }

    private fun setView() {
        toolbar.toolbarBack.visibility = View.GONE
        toolbar.toolbarSort.setOnClickListener { showSortingDialog() }
        val fragmentList = listOf(mobileListFragment, favoriteListFragment)
        pager.adapter = PageAdapter(fragmentList, supportFragmentManager)
    }

    private fun showSortingDialog() {
        mMobileListSortingDialog.show(supportFragmentManager, "Mobile List Sorting Dialog")
    }

    override fun getLayout() = R.layout.activity_main

    override fun onFavoriteClick(item: MobileListResponse, isFavorite: Boolean) {
        if (isFavorite) {
            favoriteListFragment.addFavoriteItem(item)
        } else {
            favoriteListFragment.removeFavoriteItem(item)
        }
    }

    override fun onItemClick(item: MobileListResponse) {
        val intent = Intent(this, MobileDetailActivity::class.java)
        intent.putExtra(MOBILE_ITEM_KEY, item)
        startActivity(intent)
    }

    override fun onRemoveFavoriteItem(item: MobileListResponse) {
        mobileListFragment.clearFavorite(item)
    }

    override fun onSelectSorting(sorting: SortingDialogFragment.Sorting, dialog: SortingDialogFragment) {
        when(sorting) {
            SortingDialogFragment.Sorting.PRICEHIGHTOLOW -> {
                mobileListFragment.sortList(SortingDialogFragment.Sorting.PRICEHIGHTOLOW)
                favoriteListFragment.sortList(SortingDialogFragment.Sorting.PRICEHIGHTOLOW)
            }
            SortingDialogFragment.Sorting.PRICELOWTOHIGH -> {
                mobileListFragment.sortList(SortingDialogFragment.Sorting.PRICELOWTOHIGH)
                favoriteListFragment.sortList(SortingDialogFragment.Sorting.PRICELOWTOHIGH)
            }
            SortingDialogFragment.Sorting.RATING -> {
                mobileListFragment.sortList(SortingDialogFragment.Sorting.RATING)
                favoriteListFragment.sortList(SortingDialogFragment.Sorting.RATING)
            }
            else -> { }
        }
    }
}
