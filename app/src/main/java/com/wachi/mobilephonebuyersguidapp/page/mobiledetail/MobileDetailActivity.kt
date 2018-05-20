package com.wachi.mobilephonebuyersguidapp.page.mobiledetail

import android.os.Bundle
import android.view.View
import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.base.BaseActivity
import com.wachi.mobilephonebuyersguidapp.page.main.MainActivity
import kotlinx.android.synthetic.main.activity_mobile_detail.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MobileDetailActivity : BaseActivity(), MobileDetailContract.View {

    private val mPresenter = MobileDetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attach(this@MobileDetailActivity)
        intent?.run {
            mPresenter.item = getParcelableExtra(MainActivity.MOBILE_ITEM_KEY)
        }
        mPresenter.onViewCreate()
        toolbar.toolbarSort.visibility = View.GONE
        toolbar.toolbarBack.setOnClickListener { finish() }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onViewDestroy()
    }

    override fun getLayout() = R.layout.activity_mobile_detail

    override fun setRating(text: String) {
        tvRating.text = getString(R.string.mobile_rating, text)
    }

    override fun setPrice(text: String) {
        tvPrice.text = getString(R.string.mobile_price, text)
    }

    override fun setMobileName(text: String) {
        tvMobileName.text = text
    }

    override fun setMobileBrand(text: String) {
        tvMobileBrand.text = text
    }

    override fun setMobileDescription(text: String) {
        tvMobileDescription.text = text
    }
}
