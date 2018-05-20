package com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse

import com.google.gson.annotations.SerializedName

data class MobileListResponse(

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("brand")
	val brand: String? = null,

	@field:SerializedName("thumbImageURL")
	val thumbImageURL: String? = null
)