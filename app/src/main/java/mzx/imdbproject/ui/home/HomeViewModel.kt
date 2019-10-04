package mzx.imdbproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.observers.DisposableObserver
import mzx.imdbproject.domain.entity.MovieCollectionEntity
import mzx.imdbproject.domain.entity.MovieEntity
import mzx.imdbproject.domain.usecase.GetMoviesUseCase
import mzx.imdbproject.ui.data.MovieUi
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
    ViewModel() {

    private val movieList = MutableLiveData<List<MovieUi>>().apply {
        getMoviesUseCase.execute(MovieCollectionDisposableObserver(this))

    }
    val text: LiveData<List<MovieUi>> = movieList

    class MovieCollectionDisposableObserver(private val movieUiList: MutableLiveData<List<MovieUi>>) :
        DisposableObserver<MovieCollectionEntity>() {
        override fun onComplete() {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onNext(t: MovieCollectionEntity) {
            movieUiList.value = t.results.map { movieEntity -> movieEntity.transformUi }
        }

        override fun onError(e: Throwable) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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