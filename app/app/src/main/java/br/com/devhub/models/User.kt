package br.com.devhub.models

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val cellPhone: String,
    val password: String
)
