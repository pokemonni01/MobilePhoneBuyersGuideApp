package com.wachi.mobilephonebuyersguidapp.page.mobiledetail

import com.wachi.mobilephonebuyersguidapp.base.mvp.BasePresenter
import com.wachi.mobilephonebuyersguidapp.base.mvp.BaseView
import com.wachi.mobilephonebuyersguidapp.model.MobileListAPI
import com.wachi.mobilephonebuyersguidapp.model.mobileimagelist.MobileImageListResponse

/**
 * Created by WachiGO on 20/5/2018 AD
 */
interface MobileDetailContract {

    interface View : BaseView {
        fun setRating(text: String)
        fun setPrice(text: String)
        fun setMobileName(text: String)
        fun setMobileBrand(text: String)
        fun setMobileDescription(text: String)
        fun showRootView()
        fun hideRootView()
        fun setMobileImageList(mobileImageList: List<MobileImageListResponse>)
    }

    abstract class Presenter : BasePresenter<View>(), MobileListAPI.MobileImageListListener {
        abstract fun requestMobileImageList(mobileId: Int)
    }
}