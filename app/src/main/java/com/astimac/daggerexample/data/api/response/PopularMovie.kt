package com.astimac.daggerexample.data.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by astimac on 05.03.18..
 */
data class PopularMovie(
        @SerializedName("id") val movieId: Int,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("overview") val overview: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("title") val title: String,
        @SerializedName("vote_count")  val voteCount: Int,
        @SerializedName("vote_average")  val voteAverage: Double,
        @SerializedName("backdrop_path")  val backdropPath: String,
        @SerializedName("original_language")  val originalLanguage: String
)