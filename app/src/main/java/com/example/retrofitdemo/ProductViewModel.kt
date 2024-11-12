package com.example.retrofitdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    val products = MutableStateFlow<List<Product>>(emptyList())

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            products.value = repository.getProducts()
        }
    }

    // TODO 5: Implement the function to add a product.
    fun addProduct(newProduct: Product) {
        viewModelScope.launch {
        // 1. Call the repository function to add the product (students must create this in ProductRepository).
        // 2. Once added, update the 'products' state with the new list.
        }
    }

    fun editProduct(productId: Int, updatedProduct: Product) {
        viewModelScope.launch {
            val product = repository.updateProduct(productId, updatedProduct)
            products.value = products.value.map {
                if (it.id == productId) product else it
            }
        }
    }

    // TODO 6: Implement the function to delete a product by ID.
    fun removeProduct(productId: Int) {
        viewModelScope.launch {
        // 1. Call the repository function to delete the product.
        // 2. Update 'products' to remove the deleted product from the list.
        }
    }
}
