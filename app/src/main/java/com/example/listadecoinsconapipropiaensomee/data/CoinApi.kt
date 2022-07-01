package com.example.listadecoinsconapipropiaensomee.data

import com.example.listadecoinsconapipropiaensomee.data.dto.CoinDto
import retrofit2.http.GET

interface CoinApi {
    @GET("/Coinst")
    suspend fun getCoins(): List<CoinDto>

    /*@GET("/Coinst/{MonedaId}")
    suspend fun getCoin(@Path("MonedaId") MonedaId: String): CoinDto*/
}