package mzx.imdbproject.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import mzx.imdbproject.databinding.MovieDetailFragmentBinding
import mzx.imdbproject.ui.data.MovieUi

class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var movieUi: MovieUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieUi = arguments?.let { MovieDetailFragmentArgs.fromBundle(it).movieUi }
            ?: throw IllegalArgumentException("Missing Bundle Arguments")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = MovieDetailFragmentBinding.inflate(inflater, container, false).apply {
        movieUi = this@MovieDetailFragment.movieUi

    }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
