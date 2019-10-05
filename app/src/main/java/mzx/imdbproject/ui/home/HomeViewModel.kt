package mzx.imdbproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableObserver
import mzx.imdbproject.domain.entity.MovieCollectionEntity
import mzx.imdbproject.domain.entity.MovieEntity
import mzx.imdbproject.domain.usecase.GetMoviesUseCase
import mzx.imdbproject.ui.data.MovieUi
import timber.log.Timber
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel() {

    private val _movieList = MutableLiveData<List<MovieUi>>().apply {
        getMoviesUseCase.execute(MovieCollectionDisposableObserver(this))

    }
    val movieList: LiveData<List<MovieUi>> = _movieList

    class MovieCollectionDisposableObserver(private val movieUiList: MutableLiveData<List<MovieUi>>) :
        DisposableObserver<MovieCollectionEntity>() {
        override fun onComplete() {
            Timber.i("Request completed")
        }

        override fun onNext(t: MovieCollectionEntity) {

            movieUiList.value = t.results.map { movieEntity -> movieEntity.transformUi }
        }

        override fun onError(e: Throwable) {
            Timber.i("Request Error : ${e.printStackTrace()}")
        }
    }
}

private val MovieEntity.transformUi: MovieUi
    get() = MovieUi(
        id,
        originalTitle,
        overview,
        popularity,
        posterPath,
        releaseDate,
        title,
        video,
        voteAverage,
        voteCount
    )