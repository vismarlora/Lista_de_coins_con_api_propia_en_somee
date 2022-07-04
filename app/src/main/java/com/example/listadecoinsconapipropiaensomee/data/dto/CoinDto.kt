package com.example.listadecoinsconapipropiaensomee.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinDto(
    val monedaId: Int = 0,
    val descripcion: String = "",
    val valor: Double = 0.0,
    val imageUrl: String = ""
)
