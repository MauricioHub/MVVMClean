package com.cursokotlin.mvvmexample.domain

import com.cursokotlin.mvvmexample.data.ProductRepository
import com.cursokotlin.mvvmexample.data.model.ProductModel

class GetProductsUseCase {

    private val repository = ProductRepository()
    suspend operator fun invoke():List<ProductModel>? = repository.getAllProducts()
}