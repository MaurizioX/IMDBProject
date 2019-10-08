package mzx.imdbproject.domain.usecase

import io.reactivex.Observable
import mzx.imdbproject.domain.entity.MovieCollectionEntity
import mzx.imdbproject.domain.executor.PostExecutionThread
import mzx.imdbproject.domain.executor.ThreadExecutor
import mzx.imdbproject.domain.service.MoviesService
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
    private val moviesService: MoviesService)
    : ObservableUseCase<MovieCollectionEntity, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Observable<MovieCollectionEntity> =
        moviesService.getLastMovies()


    override fun dispose() {
        super.dispose()
        moviesService.dispose()
    }
}

class SaveFavoriteMoviesUseCase @Inject constructor(
    threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
    private val moviesService: MoviesService)
    : ObservableUseCase<MovieCollectionEntity, SaveFavoriteMoviesUseCase.FavoriteInfo>(threadExecutor, postExecutionThread) {

    data class FavoriteInfo(val id:Int, val selection:Boolean)


    override fun buildUseCaseObservable(params: FavoriteInfo?): Observable<MovieCollectionEntity> =
        moviesService.saveFavoriteMovie(params)



    override fun dispose() {
        super.dispose()
        moviesService.dispose()
    }
}