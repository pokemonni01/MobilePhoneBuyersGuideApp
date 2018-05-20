package com.wachi.mobilephonebuyersguidapp.model.mobileimagelist

import com.google.gson.annotations.SerializedName

data class MobileImageListErrorResponse(

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("error")
	val error: Boolean? = null
)