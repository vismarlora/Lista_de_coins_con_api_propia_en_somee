package com.example.listadecoinsconapipropiaensomee.ui.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun CoinRegistroScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    var validar = LocalContext.current
    val focusRequesterDescripcion = FocusRequester()
    val focusRequesterPrecio = FocusRequester()

    var error by remember {
        mutableStateOf(false)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Registro  Criptomonedas",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.navigate(
                            "CoinListScreen"
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "CONSULTA",
                            //modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = viewModel.descripcion,
                label = {
                    Text(
                        text = "Moneda",
                        fontStyle = FontStyle.Italic
                    )
                },
                onValueChange = {
                    viewModel.descripcion = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterDescripcion),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyBitcoin,
                        contentDescription = null
                    )
                }
            )

            val assistiveElementText = if (error)
                "Error: Obligatorio" else "*Obligatorio"
            val assistiveElementColor = if (error) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors
                    .onSurface
                    .copy(alpha = ContentAlpha.medium)
            }

            Text(
                text = assistiveElementText,
                color = assistiveElementColor,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )

            OutlinedTextField(
                value = viewModel.valor,
                label = {
                    Text(
                        text = "Precio",
                        fontStyle = FontStyle.Italic
                    )
                },
                onValueChange = {
                    viewModel.valor = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterPrecio),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.PriceCheck,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            val assistiveText = if (error)
                "Error: Obligatorio" else "*Obligatorio"
            val assistiveColor = if (error) {
                MaterialTheme
                    .colors
                    .error
            } else {
                MaterialTheme
                    .colors
                    .onSurface
                    .copy(alpha = ContentAlpha.medium)
            }

            Text(
                text = assistiveText,
                color = assistiveColor,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )

            OutlinedTextField(
                value = viewModel.imageUrl,
                label = {
                    Text(
                        text = "Url Image",
                        fontStyle = FontStyle.Italic
                    )
                },
                onValueChange = { viewModel.imageUrl = it },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = null
                    )
                },
            )

            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Button(
                onClick = {
                    if (!viewModel.descripcion.isNullOrEmpty() || !viewModel.valor.isNullOrEmpty()) {
                        if (validar(viewModel.valor) == false) {
                            error = viewModel.valor.isBlank()
                            Toast.makeText(
                                validar,
                                "El Precio que ingreso no es valido!",
                                Toast.LENGTH_LONG
                            ).show()
                            focusRequesterPrecio.requestFocus()
                        } else {
                            if (viewModel.valor.toDouble() <= 0) {
                                error = viewModel.valor.isBlank()
                                Toast.makeText(
                                    validar,
                                    "El Precio debe ser mayor que cero!",
                                    Toast.LENGTH_LONG
                                ).show()
                                focusRequesterPrecio.requestFocus()

                            } else {
                                viewModel.Guardar()
                                navHostController.navigate("CoinListScreen")
                                Toast.makeText(
                                    validar,
                                    "Se ha Guardado Correctamente!",
                                    Toast.LENGTH_LONG
                                ).show()
                                viewModel.descripcion = ""
                                viewModel.imageUrl = ""
                                viewModel.valor = ""

                            }
                        }

                    } else {
                        error = viewModel.descripcion.isBlank()
                        Toast.makeText(
                            validar,
                            "Los Campos correspondientes están vacío!",
                            Toast.LENGTH_LONG
                        ).show()
                        focusRequesterDescripcion.requestFocus()
                    }

                    //focusRequester.requestFocus()
                },
                modifier = Modifier.padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                shape = CutCornerShape(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Text("  GUARDAR")
            }
        }
    }
}

fun validar(precio: String): Boolean {

    try {
        precio.toDouble()
        return true

    } catch (nfe: NumberFormatException) {
        return false
    }
}