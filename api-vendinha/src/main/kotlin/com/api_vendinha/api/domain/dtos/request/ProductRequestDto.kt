package com.api_vendinha.api.domain.dtos.request

data class ProductRequestDto (
    val name:String,
    val price:Float,
    val quantity:Int
)