package br.com.devhub.models

import java.util.Date

data class Post(
    val id: String,
    val userId: String,
    val title: String,
    val content: String,
    val createdAt: Date,
    val updatedAt: Date
)
