package com.example.movie.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.databinding.ItemsShowBinding
import com.example.movie.ui.detail.DetailActivity

class ShowAdapter : PagedListAdapter<Entity, ShowAdapter.ShowViewHolder>(DIFF_CALLBACK) {

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

    private val listCourses = ArrayList<Entity>()

    fun setShows(courses: List<Entity>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemsBookmarkBinding = ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val show = getItem(position)
        if (show != null){
            holder.bind(show)
        }
    }

    inner class ShowViewHolder(private val binding: ItemsShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Entity) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemDate.text = show.duration
                tvItemDesc.text = show.description

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, show.Id)
                    intent.putExtra(DetailActivity.EXTRA_TITLE,show.title)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${show.imagePath}")
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): Entity? = getItem(swipedPosition)
}