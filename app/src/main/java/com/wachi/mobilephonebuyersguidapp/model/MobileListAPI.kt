package com.wachi.mobilephonebuyersguidapp.model

import com.wachi.mobilephonebuyersguidapp.api.APIClient
import com.wachi.mobilephonebuyersguidapp.model.mobileimagelist.MobileImageListResponse
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by WachiGO on 20/5/2018 AD
 */
class MobileListAPI {

    private val mCompositeDisposable by lazy { CompositeDisposable() }
    fun clear() = mCompositeDisposable.clear()

    fun getMobileList(listener: MobileListListener) {
        mCompositeDisposable.add(
                APIClient().getAPIService().getMobileList()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onNext = { response ->
                                    listener.onGetMobileListSuccess(response)
                                },
                                onError = {
                                    e-> listener.onGetMobileListFail(e)
                                    e.printStackTrace()
                                }
                        )
        )
    }

    fun getMobileImageList(listener: MobileImageListListener, mobileId: Int) {
        mCompositeDisposable.add(
                APIClient().getAPIService().getMobileImageList(mobileId)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onNext = { response ->
                                    listener.onGetMobileImageListSuccess(response)
                                },
                                onError = {
                                    e-> listener.onGetMobileImageListFail(e)
                                    e.printStackTrace()
                                }
                        )
        )
    }

    interface MobileListListener {
        fun onGetMobileListSuccess(response: List<MobileListResponse>)
        fun onGetMobileListFail(throwable: Throwable)
    }

    interface MobileImageListListener {
        fun onGetMobileImageListSuccess(response: List<MobileImageListResponse>)
        fun onGetMobileImageListFail(throwable: Throwable)
    }
}