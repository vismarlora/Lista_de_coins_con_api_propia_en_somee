package com.example.listadecoinsconapipropiaensomee.ui.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun CoinRegistroScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    var validar = LocalContext.current
    val focusRequester = FocusRequester()
    //val focusRequesterMonto = FocusRequester()
    //val focusRequesterPrecio = FocusRequester()

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

            OutlinedTextField(
                value = "",
                label = { Text(text = "Moneda") },
                onValueChange = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.CurrencyBitcoin, contentDescription = null)
                }
            )

            OutlinedTextField(
                value = "",
                label = { Text(text = "Precio") },
                onValueChange = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.PriceCheck, contentDescription = null)
                }
            )
        }
    }
}
