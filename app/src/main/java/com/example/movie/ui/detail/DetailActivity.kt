package com.example.movie.ui.detail


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.Entity
import com.example.movie.databinding.ActivityDetailCourseBinding
import com.example.movie.databinding.ContentDetailCourseBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        supportActionBar?.title = "Details"

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_COURSE)
            if (id != null) {
                viewModel.setSelectedCourse(id)
                populatemovie(viewModel.getData())
            }
        }
    }
    private fun populatemovie(entity: Entity){
        detailContentBinding.textTitle.text = entity.title
        detailContentBinding.textDescription.text = entity.description
        detailContentBinding.textDuration.text = entity.duration
        Glide.with(this)
                .load(entity.backdropPath)
                .into(detailContentBinding.imageBackdrop)

        Glide.with(this)
                .load(entity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)

    }
}