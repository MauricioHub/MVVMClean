package com.cursokotlin.mvvmexample.data.model

import com.google.gson.annotations.SerializedName

data class CategoryModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("creationAt") val creationAt: String,
    @SerializedName("updatedAt") val updatedAt: String
)