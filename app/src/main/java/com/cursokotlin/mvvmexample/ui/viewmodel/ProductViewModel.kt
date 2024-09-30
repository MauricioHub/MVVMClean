package com.cursokotlin.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursokotlin.mvvmexample.data.model.ProductModel
import com.cursokotlin.mvvmexample.domain.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    val productModel = MutableLiveData<List<ProductModel>?>()
    val isLoading = MutableLiveData<Boolean>()

    val getProductsUseCase = GetProductsUseCase()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getProductsUseCase()

            System.out.println(">>>>>>>>>>>>>>> RESULTADO" + result)

            if (!result.isNullOrEmpty()){
                productModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}