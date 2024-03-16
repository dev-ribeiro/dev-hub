package br.com.devhub.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.devhub.dto.PostDTO
import br.com.devhub.network.PostApi
import br.com.devhub.network.retrofit
import br.com.devhub.utils.exceptions.PostException
import kotlinx.coroutines.launch

class PostService : ViewModel() {
    val postApiService = retrofit.create(PostApi::class.java)

    fun createPost(postTO: PostDTO, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = postApiService.createPost(postTO)
                if(response.code() != 200) throw PostException("Não foi possível criar o post")
                onSuccess()
            } catch (e: Exception) {
                onFailure()
            }
        }
    }
}