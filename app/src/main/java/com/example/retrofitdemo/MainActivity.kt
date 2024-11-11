package com.example.retrofitdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.retrofitdemo.ui.theme.RetrofitDemoTheme

class MainActivity : ComponentActivity() {
    private val productViewModel by viewModels<ProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductListScreen(
                        viewModel = productViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProductListScreen(viewModel: ProductViewModel, modifier: Modifier = Modifier) {
    val products = viewModel.products.collectAsState().value

    LazyColumn(modifier = modifier) {
        items(products) { product ->
            Text(text = "${product.title} - $${product.price}")
        }
    }
}
