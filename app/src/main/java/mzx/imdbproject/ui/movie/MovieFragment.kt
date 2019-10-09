package mzx.imdbproject.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import mzx.imdbproject.R
import mzx.imdbproject.ui.adapter.MoviesPagerAdapter
import mzx.imdbproject.ui.data.MovieUi
import javax.inject.Inject

class MovieFragment : DaggerFragment(), MoviesPagerAdapter.MoviesPagerAdapterListener {

    private lateinit var homeViewModel: MovieViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var moviesPagerAdapter: MoviesPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this, viewModelFactory)[MovieViewModel::class.java]
        moviesPagerAdapter = MoviesPagerAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view_pager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = moviesPagerAdapter
        }

        homeViewModel.movieList.observe(this, Observer {
            moviesPagerAdapter.submitList(it)
        })
    }

    override fun onFavoriteClicked(movieUi: MovieUi) {
        homeViewModel.updateFavorite(movieUi)
    }

    override fun onMovieClicked(movieUi: MovieUi) {
        val action = MovieFragmentDirections.actionNavMovieToMovieDetailFragment(movieUi)
        findNavController().navigate(action)
    }
}