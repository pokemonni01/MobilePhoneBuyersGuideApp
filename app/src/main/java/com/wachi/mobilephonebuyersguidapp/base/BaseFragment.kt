package com.wachi.mobilephonebuyersguidapp.base

import android.content.Context
import android.support.v4.app.Fragment
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.mvp.BaseView
import com.wachi.mobilephonebuyersguidapp.util.AppUtil
import com.wachi.mobilephonebuyersguidapp.util.ProgressBarHandler

/**
 * Created by WachiGO on 20/5/2018 AD
 */
open class BaseFragment : Fragment(), BaseView {

    private var mProgressBarHandler: ProgressBarHandler? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.run {
            mProgressBarHandler = ProgressBarHandler(this)
        }
    }

    override fun hideProgress() {
        mProgressBarHandler?.hideProgress()
    }

    override fun showProgress() {
        mProgressBarHandler?.hideProgress()
    }

    override fun showDefaultAlertDialog(title: String, message: String) {
        context?.let {
            AppUtil.alertDialog(it, title, message, true, getString(R.string.ok_button))
        }
    }

    override fun showDefaultAlertDialog(title: Int, message: Int) {
        showDefaultAlertDialog(resources.getString(title), resources.getString(message))
    }
}