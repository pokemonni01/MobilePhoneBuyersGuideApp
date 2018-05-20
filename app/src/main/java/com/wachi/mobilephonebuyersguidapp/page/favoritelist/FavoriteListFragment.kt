package com.wachi.mobilephonebuyersguidapp.page.favoritelist

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.BaseFragment
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import com.wachi.mobilephonebuyersguidapp.page.favoritelist.adapter.FavoriteListAdapter
import com.wachi.mobilephonebuyersguidapp.page.favoritelist.adapter.callback.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.fragment_favorite_list.*

class FavoriteListFragment : BaseFragment() {


    private var mListener: OnFavoriteListFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.run {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@run)
                this.adapter = FavoriteListAdapter(mutableListOf())
            }

            val swipeHandler = object : SwipeToDeleteCallback(this@run) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                    viewHolder?.run {
                        mListener?.onRemoveFavoriteItem((recyclerView.adapter as FavoriteListAdapter).getItem(viewHolder.adapterPosition))
                        (recyclerView.adapter as FavoriteListAdapter).removeAt(viewHolder.adapterPosition)
                    }
                }

            }
            val itemTouchHelper = ItemTouchHelper(swipeHandler)
            itemTouchHelper.attachToRecyclerView(recyclerView)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFavoriteListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFavoriteListFragmentInteractionListener {
        fun onRemoveFavoriteItem(item: MobileListResponse)
    }

    companion object {
        fun newInstance(): FavoriteListFragment {
            return FavoriteListFragment()
        }
    }

    fun addFavoriteItem(item: MobileListResponse) {
        (recyclerView.adapter as FavoriteListAdapter).addItem(item)
    }

    fun removeFavoriteItem(item: MobileListResponse) {
        (recyclerView.adapter as FavoriteListAdapter).removeItem(item)
    }
}
