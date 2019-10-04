package mzx.imdbproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import mzx.imdbproject.R
import mzx.imdbproject.ui.adapter.MovieAdapter
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
        movieAdapter = MovieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movie_list.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }

        homeViewModel.movieList.observe(this, Observer {

            movieAdapter.submitList(it)
        })
    }
}


//    {
//
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.movieList.observe(this, Observer {
//            textView.movieList = "Readed items ${it?.size.toString()}"
//        })
//        return root
//    }
