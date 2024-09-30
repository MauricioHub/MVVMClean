package com.cursokotlin.mvvmexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.mvvmexample.data.model.CategoryModel
import com.cursokotlin.mvvmexample.data.model.ProductModel
import com.cursokotlin.mvvmexample.databinding.ActivityMainBinding
import com.cursokotlin.mvvmexample.ui.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter

    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel.onCreate()

        productViewModel.productModel.observe(this, Observer {
            //binding.tvQuote.text = it.title
            //binding.tvAuthor.text = it.description
            if (it != null) {
                setupRecycler(it)
            }
        })

        productViewModel.isLoading.observe(this, Observer {
            //binding.progress.isVisible = it
        })


    }

    private fun setupRecycler(productList: List<ProductModel>){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializar el adaptador
        productAdapter = ProductAdapter(productList)
        binding.recyclerView.adapter = productAdapter
    }

}