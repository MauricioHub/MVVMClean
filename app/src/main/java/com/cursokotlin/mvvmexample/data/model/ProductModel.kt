package com.cursokotlin.mvvmexample.data.model

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Double,
    @SerializedName("description") val description: String,
    @SerializedName("images") val images: List<String>,
    @SerializedName("creationAt") val creationAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("category") val category: CategoryModel
)