package com.wachi.mobilephonebuyersguidapp.model.mobileimagelist

import com.google.gson.annotations.SerializedName

data class MobileImageListResponse(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("mobile_id")
	val mobileId: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)