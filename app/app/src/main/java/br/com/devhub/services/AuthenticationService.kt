package br.com.devhub.services

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.devhub.dto.UserDTO
import br.com.devhub.models.User
import br.com.devhub.network.AuthenticationApi
import br.com.devhub.network.BASE_API_URL
import br.com.devhub.network.retrofit
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthenticationService : ViewModel() {
    private val _authenticatedUser = mutableStateOf<User?>(null)
    val authenticatedUser: State<User?> = _authenticatedUser

    val authenticationApiService = retrofit.create(AuthenticationApi::class.java)

    fun registerUser(user: UserDTO, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = authenticationApiService.registerUser(user)
                if(response.code() !== 200) throw  Error()
                _authenticatedUser.value = response.body()
                onSuccess()
            } catch (e: Exception) {
                println(e)
                onFailure()
            }
        }
    }

    fun login(user: UserDTO, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = authenticationApiService.login(user)
                if(response.code() != 200) throw Exception()
                _authenticatedUser.value = response.body()
                onSuccess()
            } catch (e: Exception) {
                println(e)
                onFailure()
            }
        }
    }
}