package com.wachi.mobilephonebuyersguidapp.page.mobiledetail

import com.wachi.mobilephonebuyersguidapp.model.MobileListAPI
import com.wachi.mobilephonebuyersguidapp.model.mobileimagelist.MobileImageListResponse
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse

/**
 * Created by WachiGO on 20/5/2018 AD
 */
class MobileDetailPresenter : MobileDetailContract.Presenter() {

    var item: MobileListResponse? = null
    private val mModel = MobileListAPI()

    private fun Double.toStringTwoDigits() = String.format("%.2f", this)

    override fun onViewCreate() {
        mView?.run {
            hideRootView()
            item?.let {
                setRating(it.rating!!.toStringTwoDigits())
                setPrice(it.price!!.toStringTwoDigits())
                setMobileName(it.name!!)
                setMobileBrand(it.brand!!)
                setMobileDescription(it.description!!)
                requestMobileImageList(it.id!!)
            }
        }
    }

    override fun onViewDestroy() {
        clear()
    }

    override fun clear() {
        mModel.clear()
    }

    override fun requestMobileImageList(mobileId: Int) {
        mView?.showProgress()
        mModel.getMobileImageList(this@MobileDetailPresenter, mobileId)
    }

    override fun onGetMobileImageListSuccess(response: List<MobileImageListResponse>) {
        mView?.run {
            hideProgress()
            showRootView()
            setMobileImageList(response)
        }
    }

    override fun onGetMobileImageListFail(throwable: Throwable) {
        mView?.hideProgress()
    }
}