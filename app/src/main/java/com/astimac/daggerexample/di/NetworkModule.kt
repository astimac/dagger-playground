package com.astimac.daggerexample.di

import android.content.Context
import com.astimac.daggerexample.BuildConfig
import com.astimac.daggerexample.data.api.TheMovieDbService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by astimac on 26.02.18..
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Singleton
    @Provides
    fun provideApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()
            val url = request.url()
                    .newBuilder()
                    .addQueryParameter("api_key", "75c653782b3f9bf4d1344f021308441b")
                    .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideOkHttpCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache,
                            httpLoggingInterceptor: HttpLoggingInterceptor,
                            apiKeyInterceptor: Interceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addNetworkInterceptor(httpLoggingInterceptor)
        }

        client.addNetworkInterceptor(apiKeyInterceptor)
        return client.build()
    }

    @Singleton
    @Provides
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideApi(gsonConverterFactory: GsonConverterFactory,
                   rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                   okHttpClient: OkHttpClient) : TheMovieDbService {

        return Retrofit.Builder().baseUrl(TheMovieDbService.URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build()
                .create(TheMovieDbService::class.java)
    }
}