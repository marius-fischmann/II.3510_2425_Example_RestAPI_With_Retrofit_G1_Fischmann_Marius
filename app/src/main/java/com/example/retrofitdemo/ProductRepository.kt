package com.example.retrofitdemo

class ProductRepository {
    private val apiService = ApiClient.apiService

    suspend fun getProducts(): List<Product> {
        return apiService.getProducts().products
    }

    // TODO 3: Add a function to add a product via the apiService.
    // This function should accept a Product object and call the appropriate apiService method.

    suspend fun updateProduct(productId: Int, updatedProduct: Product): Product {
        return apiService.updateProduct(productId, updatedProduct)
    }

    // TODO 4: Add a function to delete a product via the apiService.
    // This function should accept a productId and call the appropriate apiService method.
}
