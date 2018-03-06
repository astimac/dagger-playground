package com.astimac.daggerexample.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.astimac.daggerexample.data.api.response.MovieResponse
import com.astimac.daggerexample.data.api.response.PopularMovie
import com.astimac.daggerexample.data.repository.MoviesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by astimac on 05.03.18..
 */
class MainActivityViewModel @Inject constructor(
        private val repository: MoviesRepository
): ViewModel() {

    val popularMovies = MutableLiveData<List<PopularMovie>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        compositeDisposable += repository.discoverPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onSuccess, ::onError)
    }

    private fun onSuccess(response: MovieResponse) {
        popularMovies.value = response.results
    }

    private fun onError(throwable: Throwable) {

    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}