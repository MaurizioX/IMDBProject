package mzx.imdbproject.data.room.api

import io.reactivex.Observable
import mzx.imdbproject.data.api.FavoritesApi
import mzx.imdbproject.data.model.FavoriteData
import mzx.imdbproject.data.room.FavoriteDao
import mzx.imdbproject.data.room.model.FavoriteRoom
import javax.inject.Inject

class FavoritesApiImpl @Inject constructor(private val favoriteDao: FavoriteDao) : FavoritesApi {
    override fun getFavorites(): Observable<List<FavoriteData>> =
        favoriteDao.getAllMovies().map { it }

    override fun saveFavorite(favoriteData: FavoriteData) =
        favoriteDao.insert(favoriteData as FavoriteRoom)
}