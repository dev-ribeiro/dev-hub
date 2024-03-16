package br.com.devhub.models

import java.util.Date

data class Post(
    val id: String,
    val user: User,
    val title: String,
    val description: String,
    val createdAt: Date,
    val updatedAt: Date
)
