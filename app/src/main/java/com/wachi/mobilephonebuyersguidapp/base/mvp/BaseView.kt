package com.wachi.mobilephonebuyersguidapp.base.mvp

import android.support.annotation.StringRes

/**
 * Created by WachiGO on 18/5/2018 AD
 */
interface BaseView {
    fun hideProgress()
    fun showProgress()
    fun hideKeyboard()
    fun showKeyboard()
    fun showDefaultAlertDialog(title: String , message: String)
    fun showDefaultAlertDialog(@StringRes title: Int, @StringRes message: Int)
}