package com.example.movie.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.databinding.FragmentLikedMovieBinding
import com.example.movie.databinding.FragmentMovieBinding
import com.example.movie.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class LikedMovieFragment : Fragment() {


    private lateinit var fragmentLikedMovieBinding: FragmentLikedMovieBinding

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel: LikedMovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentLikedMovieBinding = FragmentLikedMovieBinding.inflate(layoutInflater, container, false)
        return fragmentLikedMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentLikedMovieBinding.rvMovie)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[LikedMovieViewModel::class.java]

            movieAdapter = MovieAdapter()


            viewModel.getLikedMovies().observe(this,{ movies ->
                fragmentLikedMovieBinding.progressBar.visibility = View.VISIBLE
                if (movies != null) {
                    fragmentLikedMovieBinding.progressBar.visibility = View.GONE
                    movieAdapter.submitList(movies)
                }
            })

            with(fragmentLikedMovieBinding.rvMovie) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)


        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null){
                val swipedPosition = viewHolder.adapterPosition
                val entity = movieAdapter.getSwipedData(swipedPosition)
                entity?.let { viewModel.setLiked(it) }

                val snackbar = Snackbar.make(view as View,"Batalkan hapus?",Snackbar.LENGTH_LONG)
                snackbar.setAction("oke") { v ->
                    entity?.let { viewModel.setLiked(it) }
                }
                snackbar.show()
            }
        }
    })

}