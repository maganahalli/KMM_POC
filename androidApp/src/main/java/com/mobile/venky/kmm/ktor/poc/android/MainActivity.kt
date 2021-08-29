package com.mobile.venky.kmm.ktor.poc.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.venky.kmm.ktor.poc.Greeting
import com.mobile.venky.kmm.ktor.poc.android.adapter.MovieAdapter


/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

suspend fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val rv: RecyclerView = findViewById(R.id.rv)
        // Recyclier view initialization and Adapter set up
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        viewModel.movies.observe(this) {
            rv.adapter = MovieAdapter(it,this)
        }

    }
}
