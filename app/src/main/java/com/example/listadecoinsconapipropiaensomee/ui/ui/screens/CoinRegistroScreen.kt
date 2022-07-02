package com.example.listadecoinsconapipropiaensomee.ui.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun CoinRegistroScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Criptomonedas") })
        },
        floatingActionButton = {
                Icon(imageVector = Icons.Default.Save, contentDescription = null)
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp)) {

            Text(text = "Moneda")

            Text(text = "Precio")

        }
    }
}