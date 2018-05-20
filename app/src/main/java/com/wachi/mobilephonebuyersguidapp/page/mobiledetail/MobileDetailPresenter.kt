package com.wachi.mobilephonebuyersguidapp.page.mobiledetail

import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse

/**
 * Created by WachiGO on 20/5/2018 AD
 */
class MobileDetailPresenter : MobileDetailContract.Presenter() {

    var item: MobileListResponse? = null

    private fun Double.toStringTwoDigits() = String.format("%.2f", this)

    override fun onViewCreate() {
        mView?.run {
            item?.let {
                setRating(it.rating?.toStringTwoDigits() ?:"0.0")
                setPrice(it.price?.toStringTwoDigits() ?:"0.0")
                setMobileName(it.name ?:"")
                setMobileBrand(it.brand ?:"")
                setMobileDescription(it.description ?:"")
            }
        }
    }

    override fun onViewDestroy() {
        clear()
    }

    override fun clear() {

    }

    override fun requestMobileImageList(mobileId: Int) {

    }
}