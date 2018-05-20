package com.wachi.mobilephonebuyersguidapp.page.mobiledetail

import com.wachi.mobilephonebuyersguidapp.base.mvp.BasePresenter
import com.wachi.mobilephonebuyersguidapp.base.mvp.BaseView

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
    }

    abstract class Presenter : BasePresenter<View>(){
        abstract fun requestMobileImageList(mobileId: Int)
    }
}