package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.ProductRequestDto
import com.api_vendinha.api.domain.dtos.response.ProductResponseDto

interface ProductServiceInterface {
    fun save(productRequestDto: ProductRequestDto): ProductResponseDto

    //fun findUser(id: Long): ProductResponseDto

    //fun update(id: Long, productRequestDto: ProductRequestDto): ProductResponseDto
}