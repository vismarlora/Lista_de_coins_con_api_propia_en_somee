package com.example.listadecoinsconapipropiaensomee.ui.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadecoinsconapipropiaensomee.data.CoinsRepository
import com.example.listadecoinsconapipropiaensomee.data.dto.CoinDto
import com.example.listadecoinsconapipropiaensomee.ui.ui.screens.CoinListState
import com.example.listadecoinsconapipropiaensomee.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val coinsRepository: CoinsRepository
) : ViewModel() {

    var descripcion by mutableStateOf("")
    var imageUrl by mutableStateOf("")
    var valor by mutableStateOf("")

    private var _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        recargarLista()
    }

    fun recargarLista(){
        coinsRepository.getCoin().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)


        /*viewModelScope.launch {
            coinsRepository.getCoin().collect {
                _state.value = CoinListState(coins = it.data ?: emptyList())
            }
        }*/

    }

    fun Guardar(){
        viewModelScope.launch {
            coinsRepository.Inser(
                CoinDto(
                    descripcion = descripcion,
                    imageUrl = imageUrl,
                    valor = valor
                )
            )
        }
    }
}