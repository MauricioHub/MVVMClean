package com.cursokotlin.mvvmexample.data.network

import com.cursokotlin.mvvmexample.core.RetrofitHelper
import com.cursokotlin.mvvmexample.data.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts(): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductApiClient::class.java).getAllProducts()
            response.body() ?: emptyList()
        }
    }
}