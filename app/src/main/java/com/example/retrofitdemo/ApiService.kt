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

    @POST("products/add")
    suspend fun createProduct(@Body product: Product): Product

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") productId: Int, @Body updatedProduct: Product): Product

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") productId: Int): Product
}
