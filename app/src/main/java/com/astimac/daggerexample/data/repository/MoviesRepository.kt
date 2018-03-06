package com.astimac.daggerexample.data.repository

import com.astimac.daggerexample.data.repository.local.LocalRepository
import com.astimac.daggerexample.data.repository.remote.RemoteRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by astimac on 05.03.18..
 */
@Singleton
class MoviesRepository @Inject constructor(
        private val localRepository: LocalRepository,
        private val remoteRepository: RemoteRepository
) {

    fun discoverPopularMovies() = remoteRepository.discoverPopularMovies()

}