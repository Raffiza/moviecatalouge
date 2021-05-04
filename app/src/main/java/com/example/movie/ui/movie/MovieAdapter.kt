package com.example.movie.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data.Entity
import com.example.movie.databinding.ItemsMovieBinding
import com.example.movie.ui.detail.DetailActivity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.CourseViewHolder>() {

    private var listCourses = ArrayList<Entity>()

    inner class CourseViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(course: Entity){
            with(binding) {
                tvItemTitle.text = course.title
                tvItemDate.text = course.duration
                tvItemDesc.text = course.description

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_COURSE,course.Id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(course.imagePath)
                        .into(imgPoster)
            }
        }
    }

    fun setCourses(courses: List<Entity>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsAcademyBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size
}