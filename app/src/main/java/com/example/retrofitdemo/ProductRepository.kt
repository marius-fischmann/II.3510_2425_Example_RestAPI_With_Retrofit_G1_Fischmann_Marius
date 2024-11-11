package com.example.retrofitdemo

class ProductRepository {
    private val apiService = ApiClient.apiService

    suspend fun getProducts(): List<Product> {
        return apiService.getProducts().products
    }

    suspend fun createProduct(product: Product): Product {
        return apiService.createProduct(product)
    }

    suspend fun updateProduct(productId: Int, updatedProduct: Product): Product {
        return apiService.updateProduct(productId, updatedProduct)
    }

    suspend fun deleteProduct(productId: Int): Product {
        return apiService.deleteProduct(productId)
    }
}
