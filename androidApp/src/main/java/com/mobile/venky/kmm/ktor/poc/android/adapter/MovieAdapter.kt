package com.mobile.venky.kmm.ktor.poc.android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mobile.venky.kmm.ktor.poc.android.R
import com.mobile.venky.kmm.ktor.poc.android.model.MovieItem

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

class MovieAdapter (val movieList: List<MovieItem>, val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder( val card: View): RecyclerView.ViewHolder(card)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val cardView = LayoutInflater.from(parent.context).inflate(R.layout.new_movie_row,parent,false)
        return MovieViewHolder(
            cardView
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        val card = holder.card
        card.findViewById<TextView>(R.id.textView_title).text = movie.name
        card.findViewById<TextView>(R.id.textView_description).text = movie.description
        val imageView: ImageView = card.findViewById(R.id.imageView_movie)
        val imageUrlStr = "https://image.tmdb.org/t/p/w500"+movie.thumbnailUrl;
        val url = movie.withThumbnailUrl(imageUrlStr).thumbnailUrl
        imageView.load(url)


    }



    override fun getItemCount(): Int {
       return  movieList.size
    }
}

private fun ImageView.load(movieItem: MovieItem) {



}
