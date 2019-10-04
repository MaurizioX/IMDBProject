//package mzx.imdbproject.service
//
//import io.reactivex.Observable
//import mzx.imdbproject.data.api.MoviesApi
//import mzx.imdbproject.data.model.DatesData
//import mzx.imdbproject.data.model.MovieCollectionData
//import mzx.imdbproject.domain.entity.*
//import mzx.imdbproject.domain.service.MoviesService
//import javax.inject.Inject
//
//
//class MoviesServiceImpl @Inject constructor(private val moviesApi: MoviesApi) : MoviesService {
//    override fun getLastMovies(): Observable<MovieCollectionEntity> =
//        moviesApi.getLatestMovies().map { movieCollectionData: MovieCollectionData -> movieCollectionData.transform }
//
//    override fun dispose() {
//    }
//}
//
//private val DatesData.transform: DatesEntity
//    get() = DatesEntityImpl(maximum, minimum)
//private val MovieCollectionData.transform: MovieCollectionEntity?
//    get() =
//        MovieCollectionEntityImpl(
//            dates.transform,
//            page,
//            results.map {
//                MovieEntityImpl(
//                    it.adult,
//                    it.backdropPath,
//                    it.genreIds,
//                    it.id,
//                    it.originalLanguage,
//                    it.originalTitle,
//                    it.overview,
//                    it.popularity,
//                    it.posterPath,
//                    it.releaseDate,
//                    it.title,
//                    it.video,
//                    it.voteAverage,
//                    it.voteCount
//                )
//            }, totalPages, totalResults
//        )
