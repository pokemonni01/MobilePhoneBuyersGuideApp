package com.wachi.mobilephonebuyersguidapp.page.mobilelist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.mobilephonebuyersguidapp.GlideApp
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import kotlinx.android.synthetic.main.list_mobile.view.*
import android.R.attr.data
import java.util.*


/**
 * Created by WachiGO on 20/5/2018 AD
 */
class MobileListAdapter(private val listener: MobileListAdapterListener, private var mobileList: List<MobileListResponse>) : RecyclerView.Adapter<MobileListAdapter.ViewHolder>() {

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
            ivFavorite.setOnClickListener {
                item.isFavorite = !item.isFavorite
                if (item.isFavorite) {
                    ivFavorite.setImageResource(R.drawable.ic_star_black)
                } else {
                    ivFavorite.setImageResource(R.drawable.ic_star_border_black)
                }
                listener.onFavoriteClick(item, item.isFavorite)
            }
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    interface MobileListAdapterListener {
        fun onFavoriteClick(item: MobileListResponse, isFavorite: Boolean)
        fun onItemClick(item: MobileListResponse)
    }

    fun clearFavorite(item: MobileListResponse) {
        mobileList.forEachIndexed { index, mobileListResponse ->
            if ( mobileListResponse.id == item.id ) {
                mobileListResponse.isFavorite = false
                notifyItemChanged(index)
                return
            }
        }
    }

    fun sortPriceLowToHigh() {
        mobileList = mobileList.sortedBy { it.price }
        notifyDataSetChanged()
    }

    fun sortPriceHighToLow() {
        mobileList = mobileList.sortedByDescending { it.price }
        notifyDataSetChanged()
    }

    fun sortRating() {
        mobileList = mobileList.sortedByDescending { it.rating }
        notifyDataSetChanged()
    }
}