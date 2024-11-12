package com.example.retrofitdemo
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    // TODO 1: Add here an api endpoint for a POST request to add a product
    // code here

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") productId: Int, @Body updatedProduct: Product): Product

    // TODO 2: Add here an api endpoint for a DELETE request to delete a product
    // code here
}
