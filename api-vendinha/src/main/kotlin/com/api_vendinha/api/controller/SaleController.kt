package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.SaleRequestDto
import com.api_vendinha.api.domain.dtos.response.SaleResponseDto
import com.api_vendinha.api.domain.service.SaleServiceInterface
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/sale")
class SaleController (
    val saleService: SaleServiceInterface
){
    @PostMapping("/totalprice")
    fun createSale(@RequestParam userId:Long,
                   @RequestParam productId: Long,
                   @RequestParam quantity:Int):SaleResponseDto {
        return saleService.processSale(userId,productId,quantity)
    }
}