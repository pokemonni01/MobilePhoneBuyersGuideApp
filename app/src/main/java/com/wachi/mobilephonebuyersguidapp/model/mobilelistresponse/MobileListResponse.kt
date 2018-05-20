package com.wachi.mobilephonebuyersguidapp.model.mobilelistresponse

import android.os.Parcel
import android.os.Parcelable
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
		val thumbImageURL: String? = null,

		var isFavorite: Boolean = false
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Double::class.java.classLoader) as Double?,
			source.readValue(Double::class.java.classLoader) as Double?,
			source.readString(),
			source.readString(),
			source.readValue(Int::class.java.classLoader) as Int?,
			source.readString(),
			source.readString(),
			1 == source.readInt()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(price)
		writeValue(rating)
		writeString(name)
		writeString(description)
		writeValue(id)
		writeString(brand)
		writeString(thumbImageURL)
		writeInt((if (isFavorite) 1 else 0))
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<MobileListResponse> = object : Parcelable.Creator<MobileListResponse> {
			override fun createFromParcel(source: Parcel): MobileListResponse = MobileListResponse(source)
			override fun newArray(size: Int): Array<MobileListResponse?> = arrayOfNulls(size)
		}
	}
}