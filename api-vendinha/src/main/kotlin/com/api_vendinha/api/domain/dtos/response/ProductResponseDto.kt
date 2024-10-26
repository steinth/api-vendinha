package com.api_vendinha.api.domain.dtos.response

import com.api_vendinha.api.domain.entities.User

data class ProductResponseDto (
    val id:Long?,
    val price:Float,
    val quantity:Int,
    val user:User
)