package com.example.listadecoinsconapipropiaensomee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.listadecoinsconapipropiaensomee.ui.ListaDeCoinsConApiPropiaEnSomeeTheme
import com.example.listadecoinsconapipropiaensomee.ui.ui.screens.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint

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

/*@Composable
fun CoinListScreen(
    viewModel: CoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta de Criptomonedas    $",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold)})
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
}*/

/*@Composable
fun CoinItem(
    coin:CoinDto,
    onClick : (CoinDto) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 2.dp).fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .clickable { onClick(coin) }.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row{
                AsyncImage(modifier = Modifier.size(55.dp),
                    model = ImageRequest.Builder(LocalContext.current).data(coin.imageUrl)
                        .crossfade(true).build(),
                    contentDescription = coin.descripcion,
                )

                Spacer(modifier = Modifier.width(10.dp))
                    Text(text = coin.descripcion, fontWeight = FontWeight.Bold)
            }

            val decimal = DecimalFormat("#,###.######")

            Text(
                text = "$" + decimal.format(coin.valor.toDouble()), color = Color.Blue, fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End
            )
        }
    }
}*/


//RUTA: data/remote/dto

/*data class CoinDto(
    val monedaId: Int = 0,
    val descripcion: String = "",
    val valor: String = "",
    val imageUrl: String = ""
)*/

//RUTA: data/remote

/*interface CoinApi {
    @GET("/Coinst")
    suspend fun getCoins(): List<CoinDto>

    *//*@GET("/Coinst/{MonedaId}")
    suspend fun getCoin(@Path("MonedaId") MonedaId: String): CoinDto*//*
}*/


/*class CoinsRepository @Inject constructor(
    private val api: CoinApi
) {
    fun getCoin(): Flow<Resource<List<CoinDto>>> = flow {
        try {
            emit(Resource.Loading()) //indicar que estamos cargando

            val coins = api.getCoins() //descarga las monedas de internet, se supone quedemora algo

            emit(Resource.Success(coins)) //indicar que se cargo correctamente y pasarle las monedas
        } catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }
}*/

/*data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinDto> = emptyList(),
    val error: String = ""
)*/

/*@HiltViewModel
class CoinViewModel @Inject constructor(
    private val coinsRepository: CoinsRepository
) : ViewModel() {

    private var _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
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
    }
}*/
