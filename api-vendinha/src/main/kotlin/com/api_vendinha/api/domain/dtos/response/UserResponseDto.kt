package com.api_vendinha.api.domain.dtos.response

data class UserResponseDto(

    val id: Long?,

    val name: String,
    val email: String,
    val password: String,
    val cpf_cnpj: String,
    val is_active: Boolean
)
