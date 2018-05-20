package com.wachi.mobilephonebuyersguidapp.page.main

import com.wachi.mobilephonebuyersguidapp.base.mvp.BasePresenter
import com.wachi.mobilephonebuyersguidapp.base.mvp.BaseView

/**
 * Created by WachiGO on 20/5/2018 AD
 */
interface MainContract {
    interface View : BaseView {
    }

    abstract class Presenter : BasePresenter<View>(){
    }
}