package com.example.listadecoinsconapipropiaensomee.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinDto(
    val monedaId: Int = 0,
    val descripcion: String = "",
    val valor: String = "",
    val imageUrl: String = ""
)
