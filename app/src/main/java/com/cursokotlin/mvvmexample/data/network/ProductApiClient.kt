package com.cursokotlin.mvvmexample.data.network

import com.cursokotlin.mvvmexample.data.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("products")
    suspend fun getAllProducts(): Response<List<ProductModel>>
}