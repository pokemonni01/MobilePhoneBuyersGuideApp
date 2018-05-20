package com.wachi.mobilephonebuyersguidapp.api

import com.wachi.mobilephonebuyersguidapp.model.mobileimagelist.MobileImageListResponse
import com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse.MobileListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("./")
    fun getMobileList(): Observable<List<MobileListResponse>>

    @GET("./{id}/images")
    fun getMobileImageList(@Path("id") id: Int): Observable<List<MobileImageListResponse>>
}