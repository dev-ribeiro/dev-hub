package br.com.devhub.services

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.devhub.dto.PostDTO
import br.com.devhub.models.Post
import br.com.devhub.models.User
import br.com.devhub.network.PostApi
import br.com.devhub.network.retrofit
import br.com.devhub.utils.exceptions.PostException
import kotlinx.coroutines.launch

class PostService : ViewModel() {
    val postApiService = retrofit.create(PostApi::class.java)

    private val _posts = mutableStateListOf<Post>()
    val posts: SnapshotStateList<Post> = _posts

    fun createPost(postTO: PostDTO, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = postApiService.createPost(postTO)
                if (response.code() != 200) throw PostException("Não foi possível criar o post")
                onSuccess()
            } catch (e: Exception) {
                onFailure()
            }
        }
    }

    fun findAll(
        postTO: PostDTO,
        onSuccess: (message: String?) -> Unit,
        onFailure: (message: String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = postApiService.findAll(postTO)
                if (response.code() != 200) throw PostException("Não foi possível buscar os posts")
                response.body().let {
                    if (it != null) {
                        for (post in it.response) {
                            posts.add(post)
                        }

                        onSuccess("Posts recuperados com sucesso")
                    }
                }
            } catch (e: PostException) {
                onFailure(e.message)
            } catch (e: Exception) {
                onFailure(null)
            }
        }
    }
}