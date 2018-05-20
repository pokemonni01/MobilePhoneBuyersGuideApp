package com.wachi.mobilephonebuyersguidapp.page.mobilelist

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.BaseFragment
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import com.wachi.mobilephonebuyersguidapp.page.mobilelist.adapter.MobileListAdapter
import kotlinx.android.synthetic.main.fragment_mobile_list.*

class MobileListFragment : BaseFragment(), MobileListContract.View, MobileListAdapter.MobileListAdapterListener {

    private var mListener: OnMobileListFragmentInteractionListener? = null
    private val mPresenter = MobileListPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile_list, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mPresenter.attach(this@MobileListFragment)
        if (context is OnMobileListFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mPresenter.detach()
        mListener = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.requestMobileList()
    }

    override fun setRecyclerView(list: List<MobileListResponse>) {
        context?.run {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@run)
                this.adapter = MobileListAdapter(this@MobileListFragment, list)
            }
        }
    }

    override fun onFavoriteClick(item: MobileListResponse, isFavorite: Boolean) {
        mListener?.onFavoriteClick(item, isFavorite)
    }

    override fun onItemClick(item: MobileListResponse) {
        mListener?.onItemClick(item)
    }

    interface OnMobileListFragmentInteractionListener {
        fun onFavoriteClick(item: MobileListResponse, isFavorite: Boolean)
        fun onItemClick(item: MobileListResponse)
    }

    companion object {
        fun newInstance(): MobileListFragment {
            return MobileListFragment()
        }
    }

    fun clearFavorite(item: MobileListResponse) {
        (recyclerView.adapter as MobileListAdapter).clearFavorite(item)
    }
}