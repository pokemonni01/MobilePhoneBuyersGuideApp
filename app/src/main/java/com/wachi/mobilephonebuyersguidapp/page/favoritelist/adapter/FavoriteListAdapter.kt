package com.wachi.mobilephonebuyersguidapp.page.favoritelist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.mobilephonebuyersguidapp.GlideApp
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import kotlinx.android.synthetic.main.list_mobile.view.*


/**
 * Created by WachiGO on 20/5/2018 AD
 */
class FavoriteListAdapter(private val listener: FavoriteListAdapterListener, private var mobileList: MutableList<MobileListResponse>) : RecyclerView.Adapter<FavoriteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_mobile, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = mobileList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mobileList[position])

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        private fun Double.toStringTwoDigits() = String.format("%.2f", this)

        fun bind(item: MobileListResponse) = with(itemView) {
            tvMobileName.text = item.name
            GlideApp.with(this)
                    .load(item.thumbImageURL)
                    .fitCenter()
                    .into(ivMobileImage)
            tvMobileDescription.text = item.description
            tvPrice.text = context.getString(R.string.mobile_price, item.price?.toStringTwoDigits() ?:"0.0")
            tvRating.text = context.getString(R.string.mobile_rating, item.rating?.toStringTwoDigits() ?:"0.0")
            if (item.isFavorite) {
                ivFavorite.setImageResource(R.drawable.ic_star_black)
            } else {
                ivFavorite.setImageResource(R.drawable.ic_star_border_black)
            }
            ivFavorite.visibility = View.GONE
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    interface FavoriteListAdapterListener {
        fun onItemClick(item: MobileListResponse)
    }

    fun addItem(item: MobileListResponse) {
        for (mobileListResponse in mobileList) {
            if (mobileListResponse.id == item.id) {
                return
            }
        }
        mobileList.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(item: MobileListResponse) {
        val iterator = mobileList.iterator()
        while (iterator.hasNext()) {
            if (iterator.next().id == item.id) {
                iterator.remove()
                notifyDataSetChanged()
                return
            }
        }
    }

    fun removeAt(position: Int) {
        mobileList.removeAt(position)
        notifyDataSetChanged()
    }

    fun getItem(position: Int) = mobileList[position]

    fun sortPriceLowToHigh() {
        mobileList = mobileList.sortedBy { it.price }.toMutableList()
        notifyDataSetChanged()
    }

    fun sortPriceHighToLow() {
        mobileList = mobileList.sortedByDescending { it.price }.toMutableList()
        notifyDataSetChanged()
    }

    fun sortRating() {
        mobileList = mobileList.sortedByDescending { it.rating }.toMutableList()
        notifyDataSetChanged()
    }
}