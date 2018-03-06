package com.astimac.daggerexample.data.api.response

/**
 * Created by astimac on 05.03.18..
 */
data class MovieResponse(
        val page: Int,
        val total_results: Int,
        val total_pages: Int,
        val results: List<PopularMovie>
)