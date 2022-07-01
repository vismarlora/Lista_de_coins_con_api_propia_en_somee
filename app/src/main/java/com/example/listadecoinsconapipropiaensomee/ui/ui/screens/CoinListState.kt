package com.example.listadecoinsconapipropiaensomee.ui.screens

import com.example.listadecoinsconapipropiaensomee.data.dto.CoinDto

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinDto> = emptyList(),
    val error: String = ""
)