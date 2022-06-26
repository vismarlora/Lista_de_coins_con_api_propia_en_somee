package com.example.listadecoinsconapipropiaensomee.di

import com.example.listadecoinsconapipropiaensomee.CoinApi
import com.example.listadecoinsconapipropiaensomee.CoinsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }




    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi): CoinsRepository {
        return CoinsRepository(coinApi)
    }
}