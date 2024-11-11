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

    fun addProduct(product: Product) {
        viewModelScope.launch {
            val newProduct = repository.createProduct(product)
            products.value = products.value + newProduct
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

    fun removeProduct(productId: Int) {
        viewModelScope.launch {
            repository.deleteProduct(productId)
            products.value = products.value.filter { it.id != productId }
        }
    }
}
