package br.com.devhub.network

import br.com.devhub.dto.UserDTO
import br.com.devhub.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("auth/register")
    suspend fun registerUser(@Body user: UserDTO): Response<User>

    @POST("auth/login")
    suspend fun login(@Body user: UserDTO): Response<User>
}