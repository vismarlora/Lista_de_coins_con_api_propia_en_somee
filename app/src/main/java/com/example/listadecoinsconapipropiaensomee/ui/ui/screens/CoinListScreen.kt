package com.example.listadecoinsconapipropiaensomee.ui.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.listadecoinsconapipropiaensomee.ui.ui.screens.componentes.CoinItem

@Composable
fun CoinListScreen(
    viewModel: CoinViewModel = hiltViewModel(),
    navHostController: NavHostController,
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta de Criptomonedas    $",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold)
            })
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { navHostController.navigate("CoinRegistroScreen") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        Column(modifier = Modifier.padding(it).fillMaxWidth()) {
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(state.coins){ coin ->
                    CoinItem(coin = coin, {})
                }
            }

            if (state.isLoading)
                CircularProgressIndicator()
        }
    }
}