package com.wachi.mobilephonebuyersguidapp.page.mobilelist

import com.wachi.mobilephonebuyersguidapp.R
import com.wachi.mobilephonebuyersguidapp.model.MobileListAPI
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import retrofit2.HttpException


/**
 * Created by WachiGO on 20/5/2018 AD
 */
class MobileListPresenter : MobileListContract.Presenter() {

    private val mModel = MobileListAPI()

    override fun clear() {
        mModel.clear()
    }

    override fun requestMobileList() {
        mView?.showProgress()
        mModel.getMobileList(this@MobileListPresenter)
    }

    override fun onGetMobileListSuccess(response: List<MobileListResponse>) {
        mView?.run {
            hideProgress()
            setRecyclerView(response)
        }
    }

    override fun onGetMobileListFail(throwable: Throwable) {
        mView?.hideProgress()
        when (throwable) {
            is HttpException -> {
//                val responseBody = throwable.response().errorBody()
//                if (responseBody != null) {
//                    val responseBodyString = responseBody.string()
//                    val errorResponse = Gson().fromJson(responseBodyString, Array<MobileListResponse>::class.java).asList()
//                }
            }
            else -> {
                mView?.run {
                    showDefaultAlertDialog(R.string.alert_title_error, R.string.alert_message_cannot_connect_to_server)
                }
            }
        }
    }
}