package br.com.devhub.dto

data class ResponseDTO<T>(
    var success: Boolean,
    var numberOfElements: Int,
    var response: T
)
