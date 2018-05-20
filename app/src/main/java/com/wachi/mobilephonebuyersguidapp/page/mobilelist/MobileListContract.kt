package com.wachi.mobilephonebuyersguidapp.page.mobilelist

import com.wachi.mobilephonebuyersguidapp.base.mvp.BasePresenter
import com.wachi.mobilephonebuyersguidapp.base.mvp.BaseView
import com.wachi.mobilephonebuyersguidapp.model.MobileListAPI
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse

/**
 * Created by WachiGO on 20/5/2018 AD
 */
interface MobileListContract {
    interface View : BaseView {
        fun setRecyclerView(list: List<MobileListResponse>)
    }

    abstract class Presenter : BasePresenter<View>(), MobileListAPI.MobileListListener{
        abstract fun requestMobileList()
    }
}