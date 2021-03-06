package com.wachi.mobilephonebuyersguidapp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.mvp.BaseView
import com.wachi.mobilephonebuyersguidapp.util.AppUtil
import com.wachi.mobilephonebuyersguidapp.util.ProgressBarHandler

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private lateinit var mProgressBarHandler: ProgressBarHandler
    /**
     * get layout to inflate
     */
    @LayoutRes
    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        mProgressBarHandler = ProgressBarHandler(this@BaseActivity)

    }

    override fun showProgress() {
        mProgressBarHandler.showProgress()
    }

    override fun hideProgress() {
        mProgressBarHandler.hideProgress()
    }

    override fun showDefaultAlertDialog(title: String, message: String) {
        AppUtil.alertDialog(this@BaseActivity, title, message, true, getString(R.string.ok_button))
    }

    override fun showDefaultAlertDialog(@StringRes title: Int, @StringRes message: Int) {
        showDefaultAlertDialog(getString(title), getString(message))
    }
}