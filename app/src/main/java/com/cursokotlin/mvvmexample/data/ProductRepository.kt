package com.cursokotlin.mvvmexample.data

import com.cursokotlin.mvvmexample.data.model.ProductModel
import com.cursokotlin.mvvmexample.data.model.QuoteProvider
import com.cursokotlin.mvvmexample.data.network.ProductService

class ProductRepository {

    private val api = ProductService()

    suspend fun getAllProducts(): List<ProductModel>{
        val response = api.getProducts()
        QuoteProvider.quotes = response
        return response
    }
}