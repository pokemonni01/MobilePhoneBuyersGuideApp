package com.wachi.mobilephonebuyersguidapp.api

import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("./")
    fun getMobileList(): Observable<List<MobileListResponse>>

}