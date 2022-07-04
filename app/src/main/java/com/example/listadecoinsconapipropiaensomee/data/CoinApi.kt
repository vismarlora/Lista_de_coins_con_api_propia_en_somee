package com.example.listadecoinsconapipropiaensomee.data

import com.example.listadecoinsconapipropiaensomee.data.dto.CoinDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoinApi {
    @GET("/Coinst")
    suspend fun getCoins(): List<CoinDto>

    @POST("/Coinst")
    suspend fun PostInser(@Body coinDto: CoinDto): CoinDto

    /*@GET("/Coinst/{MonedaId}")
    suspend fun getCoin(@Path("MonedaId") MonedaId: String): CoinDto*/
}