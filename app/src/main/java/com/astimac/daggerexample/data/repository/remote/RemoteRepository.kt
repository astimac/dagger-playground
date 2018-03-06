package com.astimac.daggerexample.data.repository.remote

import com.astimac.daggerexample.data.api.TheMovieDbService
import javax.inject.Inject

/**
 * Created by astimac on 05.03.18..
 */
class RemoteRepository @Inject constructor(private val service: TheMovieDbService) {

    fun discoverPopularMovies() = service.discoverMostPopular()
}