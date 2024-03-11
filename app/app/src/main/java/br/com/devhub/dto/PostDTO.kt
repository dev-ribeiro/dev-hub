package br.com.devhub.dto

import br.com.devhub.models.User
import java.util.Date

data class PostDTO(
    val id: String,
    val user: User,
    val title: String,
    val content: String,
    val createdAt: Date,
    val updatedAt: Date
)