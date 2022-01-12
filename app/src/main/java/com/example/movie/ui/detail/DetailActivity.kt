package com.example.movie.ui.detail


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.source.local.entity.Entity
import com.example.movie.databinding.ActivityDetailCourseBinding
import com.example.movie.databinding.ContentDetailCourseBinding
import com.example.movie.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailCourseBinding: ActivityDetailCourseBinding
    private lateinit var detailContentBinding: ContentDetailCourseBinding

    private lateinit var viewModel : DetailViewModel
    private var menu:Menu? = null

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TITLE = "extra_title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        supportActionBar?.title = "Details"

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this,factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_ID)
            val title = extras.getString(EXTRA_TITLE)
            if (id != null) {

                activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
                activityDetailCourseBinding.contentHolder.visibility = View.GONE

                viewModel.setSelectedCourse(id,title!!)
                viewModel.dataRepository.observe(this,{ data ->
                    if (data != null){
                        activityDetailCourseBinding.progressBar.visibility = View.GONE
                        activityDetailCourseBinding.contentHolder.visibility = View.VISIBLE
                    }
                })
                viewModel.dataRepository.observe(this,{ data ->
                    if (data != null){
                        populatemovie(data)
                    }
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        this.menu = menu
        viewModel.dataRepository.observe(this,{ data ->
            if (data != null){
                val state = data.liked
                setLikedState(state)
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_like){
            viewModel.setLiked()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setLikedState(state: Boolean){
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_like)
        if (state){
            menuItem?.icon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_favorite_24)
        }
        else{
            menuItem?.icon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_favorite_border_24)
        }
    }
    private fun populatemovie(entity: Entity){
        detailContentBinding.textTitle.text = entity.title
        detailContentBinding.textDescription.text = entity.description
        detailContentBinding.textDuration.text = entity.duration
        Glide.with(this)
                .load("https://www.themoviedb.org/t/p/original${entity.backdropPath}")
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(detailContentBinding.imageBackdrop)

        Glide.with(this)
                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${entity.imagePath}")
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)

    }
}