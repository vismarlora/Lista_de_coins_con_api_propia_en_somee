package com.example.listadecoinsconapipropiaensomee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listadecoinsconapipropiaensomee.ui.theme.ListaDeCoinsConApiPropiaEnSomeeTheme
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.http.GET
import retrofit2.http.Path

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeCoinsConApiPropiaEnSomeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoinListScreen()
                }
            }
        }
    }
}

@Composable
fun CoinListScreen(
    viewModel: CoinViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items( state.coins){ coin ->
                CoinItem(coin = coin, {})
            }
        }

        if (state.isLoading)
            CircularProgressIndicator()

    }

}

@Composable
fun CoinItem(
    coin:CoinDto,
    onClick : (CoinDto) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(coin) }
        .padding(16.dp)
    ) {
        Text(
            text = "${coin.Descripcion} (${coin.ImageUrl})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )

    }

}

//RUTA: data/remote/dto
data class CoinDto(
    val MonedaId: Int = 0,
    val Descripcion: String = "",
    val Valor: Double,
    val ImageUrl: String = ""
)

//RUTA: data/remote
interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoin(@Path("coinId") coinId: String): CoinDto
}

