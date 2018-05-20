package com.wachi.mobilephonebuyersguidapp.base.mvp

/**
 * Created by WachiGO on 19/5/2018 AD
 */
abstract class BasePresenter<V: BaseView> {

    protected var mView: V? = null

    fun attach(view: V?) {
        view?.let {
            mView = view
        }
    }

    fun detach() {
        clear()
        mView = null
    }

    abstract fun clear()

    open fun onViewCreate() {}

    open fun onViewStart() {}

    open fun onViewResume() {}

    open fun onViewPause() {}

    open fun onViewStop() {}

    open fun onViewRestart() {}

    open fun onViewDestroy() {}
}