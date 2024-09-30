package com.cursokotlin.mvvmexample.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.mvvmexample.R
import com.cursokotlin.mvvmexample.data.model.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: List<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.product_image)
        val productTitle: TextView = view.findViewById(R.id.product_title)
        val productPrice: TextView = view.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        // Cargar la imagen usando Picasso
        Picasso.get()
            .load(product.images[0]) // Tomamos la primera imagen
            .into(holder.productImage)

        holder.productTitle.text = product.title
        holder.productPrice.text = "$${product.price}"
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}