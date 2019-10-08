package mzx.imdbproject.data.api

import io.reactivex.Observable
import mzx.imdbproject.data.model.FavoriteData

interface FavoritesApi {
    fun getFavorites(): Observable<List<FavoriteData>>
    fun saveFavorite(favoriteData: FavoriteData)
}