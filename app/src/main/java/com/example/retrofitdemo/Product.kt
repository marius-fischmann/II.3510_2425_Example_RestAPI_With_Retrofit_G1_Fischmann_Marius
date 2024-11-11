package com.example.retrofitdemo

data class Product(
    val id: Int,
    val title: String,
    val price: Double
)

data class ProductResponse(
    val products: List<Product>
)
