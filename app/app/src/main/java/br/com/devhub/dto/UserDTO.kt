package br.com.devhub.dto

data class UserDTO(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val cellPhone: String?,
    val password: String?
) {
    constructor(email: String, password: String) : this(
        firstName = null,
        lastName = null,
        email = email,
        cellPhone = null,
        password = password
    )
}
