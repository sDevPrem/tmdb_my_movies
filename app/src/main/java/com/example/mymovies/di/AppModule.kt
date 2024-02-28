package com.example.mymovies.di

import com.example.mymovies.data.datasource.AuthInterceptor
import com.example.mymovies.data.datasource.MovieDataSource
import com.example.mymovies.data.repository.MovieRepositoryImpl
import com.example.mymovies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {
        @Singleton
        @Provides
        fun providesBaseUrl(): String {
            return "https://api.themoviedb.org/3/"
        }

        @Singleton
        @Provides
        fun providesConverterFactory(): Converter.Factory {
            return GsonConverterFactory.create()
        }

        @Singleton
        @Provides
        fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor())
            .build();


        @Singleton
        @Provides
        fun providesRetrofit(
            baseUrl: String,
            converterFactory: Converter.Factory,
            okHttpClient: OkHttpClient
        ): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)

            return retrofit.build()
        }

        @Singleton
        @Provides
        fun providesMoviesDataSource(retrofit: Retrofit): MovieDataSource =
            retrofit.create(MovieDataSource::class.java)
    }

    @Singleton
    @Binds
    abstract fun providesMovieRepository(repositoryImpl: MovieRepositoryImpl):
            MovieRepository
}