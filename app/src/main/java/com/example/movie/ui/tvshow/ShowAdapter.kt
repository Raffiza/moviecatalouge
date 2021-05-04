package com.example.movie.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.Entity
import com.example.movie.databinding.ItemsShowBinding
import com.example.movie.ui.detail.DetailActivity

class ShowAdapter : RecyclerView.Adapter<ShowAdapter.CourseViewHolder>() {
    private val listCourses = ArrayList<Entity>()

    fun setCourses(courses: List<Entity>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsBookmarkBinding = ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size

    inner class CourseViewHolder(private val binding: ItemsShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Entity) {
            with(binding) {
                tvItemTitle.text = course.title
                tvItemDate.text = course.duration
                tvItemDesc.text = course.description

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_COURSE, course.Id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(course.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}