package com.example.exhibitionsapp.data.model

import com.google.gson.annotations.SerializedName

data class ExhibitionResponse(
    @SerializedName("data")
    var data: ArrayList<ExhibitionData> = arrayListOf(),
)

data class ExhibitionData(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("api_model") var apiModel: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("short_description") var shortDescription: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("status") var status: String? = null,
)