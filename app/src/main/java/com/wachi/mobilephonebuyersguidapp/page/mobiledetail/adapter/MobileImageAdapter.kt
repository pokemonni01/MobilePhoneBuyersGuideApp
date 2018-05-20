package com.wachi.mobilephonebuyersguidapp.page.mobiledetail.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.mobilephonebuyersguidapp.GlideApp
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.model.mobileimagelist.MobileImageListResponse
import kotlinx.android.synthetic.main.layout_mobile_image.view.*


/**
 * Created by WachiGO on 20/5/2018 AD
 */
class MobileImageAdapter(private val mobileImageList: List<MobileImageListResponse>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    override fun getCount() = mobileImageList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.layout_mobile_image, null)
        val item = mobileImageList[position]
        GlideApp.with(view)
                .load(item.url?.validateUrlProtocol() ?:"")
                .fitCenter()
                .into(view.ivMobileImage)
        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    private fun String.validateUrlProtocol(): String {
        return if (this.contains("https://") || this.contains("http://")) {
            this
        } else {
            "https://$this"
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}