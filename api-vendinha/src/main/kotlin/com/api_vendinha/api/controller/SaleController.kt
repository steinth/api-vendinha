package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.SaleRequestDto
import com.api_vendinha.api.domain.dtos.response.SaleResponseDto
import com.api_vendinha.api.domain.service.SaleServiceInterface
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/sale")
class SaleController (
    val saleService: SaleServiceInterface
){
    @PostMapping("/totalprice")
    fun createSale(@RequestBody saleRequest: SaleRequestDto): SaleResponseDto {
        return saleService.processSale(saleRequest.userId, saleRequest.productId, saleRequest.quantity)
    }
}