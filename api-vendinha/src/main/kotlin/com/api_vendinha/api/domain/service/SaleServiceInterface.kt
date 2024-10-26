package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.SaleRequestDto
import com.api_vendinha.api.domain.dtos.response.SaleResponseDto

interface SaleServiceInterface {
    fun processSale(userId:Long, productId: Long, quantity:Int): SaleResponseDto
}