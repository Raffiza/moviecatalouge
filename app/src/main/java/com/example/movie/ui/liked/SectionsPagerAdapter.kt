package com.example.movie.ui.liked

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movie.R
import com.example.movie.ui.movie.LikedMovieFragment
import com.example.movie.ui.tvshow.LikedShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_shows)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> LikedMovieFragment()
                1 -> LikedShowFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}