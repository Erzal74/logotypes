package com.example.logotypes

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                val response = Retrofit.retrofitService.getAllLogos()
                val data = mutableListOf<LogoAdapter.Item>()

                // Process the response into Adapter-compatible items
                for ((category, logos) in response.records) {
                    data.add(LogoAdapter.Item.Header(category))
                    for (logo in logos) {
                        Log.d("MainActivity", "Logo URL: ${logo.logo}") // Debugging URL
                        data.add(LogoAdapter.Item.Logo(logo)) // Wrap Logo in Item.Logo
                    }
                }

                recyclerView.adapter = LogoAdapter(data)
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching logos: ${e.message}", e)
            }
        }
    }
}
