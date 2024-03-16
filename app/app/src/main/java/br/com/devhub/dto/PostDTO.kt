package br.com.devhub.dto

import br.com.devhub.models.User
import java.text.SimpleDateFormat
import java.util.Date

data class PostDTO(
    val id: String?,
    val user: User,
    val title: String,
    val description: String,
    val createdAt: String,
    val updatedAt: String
) {
    constructor(user: User, title: String, content: String) : this(
        user = user,
        title = title,
        description = content,
        createdAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(Date()),
        updatedAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(Date()),
        id = null
    )
}