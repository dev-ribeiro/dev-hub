package br.com.devhub.network

import br.com.devhub.dto.PostDTO
import br.com.devhub.dto.ResponseDTO
import br.com.devhub.models.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PostApi {
    @POST("post/create")
    suspend fun createPost(@Body post: PostDTO): Response<ResponseDTO<Post>>;
}