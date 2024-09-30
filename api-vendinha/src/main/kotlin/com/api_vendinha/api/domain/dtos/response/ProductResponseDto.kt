package com.api_vendinha.api.domain.dtos.response

data class ProductResponseDto (
    val id:Long?,
    val name:String,
    val price:Float,
    val quantity:Int
)