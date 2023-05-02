package hu.bme.aut.roverphotogallery.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.bme.aut.roverphotogallery.data.RoverPhotos
import hu.bme.aut.roverphotogallery.network.MarsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MarsUiState {
    data class Success(val roverPhotsResult: RoverPhotos) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}
class NasaMarsViewModel() : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)

    init {
        getRoverPhotos("2015-6-3")
    }

    fun getRoverPhotos(date: String) {
        marsUiState = MarsUiState.Loading
        viewModelScope.launch {
            marsUiState = try {
                val result = MarsApi.retrofitService.getRoverPhotos(
                    date,"DEMO_KEY"
                )
                MarsUiState.Success(result)
            } catch (e: IOException) {
                MarsUiState.Error
            } catch (e: HttpException) {
                MarsUiState.Error
            }
        }
    }
}