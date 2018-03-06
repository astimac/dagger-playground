package com.astimac.daggerexample.data.api

import com.astimac.daggerexample.data.api.response.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by astimac on 05.03.18..
 */
interface TheMovieDbService {

    companion object {
        const val URL = "https://api.themoviedb.org/3/"
    }

    @GET("discover/movie")
    fun discoverMostPopular(@Query("sort_by") sort: String = "popularity.desc"): Flowable<MovieResponse>

}