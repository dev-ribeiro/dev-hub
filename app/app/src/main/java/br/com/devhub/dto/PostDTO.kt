package br.com.devhub.dto

import br.com.devhub.models.User
import br.com.devhub.utils.enums.Direction
import java.text.SimpleDateFormat
import java.util.Date

data class PostDTO(
    val id: String?,
    val user: User?,
    val title: String?,
    val description: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val page: Int?,
    val size: Int?,
    val direction: Direction?,
    val by: List<String>?
) {
    constructor(user: User, title: String, content: String) : this(
        user = user,
        title = title,
        description = content,
        createdAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(Date()),
        updatedAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(Date()),
        id = null,
        page = null,
        size = null,
        direction = null,
        by = null
    )

    constructor(page: Int, size: Int, direction: Direction, by: List<String>) : this (
        page = page,
        size = size,
        direction = direction,
        by = by,
        id = null,
        user = null,
        title = null,
        description = null,
        createdAt = null,
        updatedAt = null
    )
}