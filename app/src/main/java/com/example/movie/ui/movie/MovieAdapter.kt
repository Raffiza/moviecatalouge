package com.example.movie.ui.movie

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.databinding.ItemsMovieBinding
import com.example.movie.ui.detail.DetailActivity

class MovieAdapter: PagedListAdapter<Entity,MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Entity>(){
            override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                return oldItem.Id == newItem.Id
            }

            override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var listMovie = ArrayList<Entity>()

    inner class MovieViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Entity){
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.duration
                tvItemDesc.text = movie.description

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID,movie.Id)
                    intent.putExtra(DetailActivity.EXTRA_TITLE,movie.title)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movie.imagePath}")
                        .into(imgPoster)
            }
        }
    }

    fun setMovies(movies: List<Entity>?) {
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null){
            holder.bind(movie)
        }
        else{
            Log.i("movie","null")
        }
    }

    fun getSwipedData(swipedPosition: Int): Entity? = getItem(swipedPosition)
}