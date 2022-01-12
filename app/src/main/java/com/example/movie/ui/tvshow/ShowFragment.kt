package com.example.movie.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.databinding.FragmentShowBinding
import com.example.movie.viewmodel.ViewModelFactory
import com.example.movie.vo.Status


class ShowFragment : Fragment(){

    lateinit var fragmentshowBinding: FragmentShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentshowBinding = FragmentShowBinding.inflate(inflater, container, false)
        return fragmentshowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]


            val showAdapter = ShowAdapter()

            fragmentshowBinding.progressBar.visibility = View.VISIBLE

            viewModel.getShows().observe(this,{ shows ->
                if (shows != null) {
                    when(shows.status){
                        Status.LOADING -> fragmentshowBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentshowBinding.progressBar.visibility = View.GONE
                            showAdapter.submitList(shows.data)
                        }
                        Status.ERROR -> {
                            fragmentshowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context,"Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
            with(fragmentshowBinding.rvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = showAdapter
            }
        }
    }



}