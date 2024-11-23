package com.api_vendinha.api.controller

import com.api_vendinha.api.domain.dtos.request.ProductRequestDto
import com.api_vendinha.api.domain.dtos.response.ProductResponseDto
import com.api_vendinha.api.domain.service.ProductServiceInterface
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
class ProductController (
    val productService: ProductServiceInterface
){
    @PostMapping("/save")
    fun save(@RequestBody productRequestDto: ProductRequestDto): ProductResponseDto{
        return productService.save(productRequestDto)
    }

    @GetMapping("list")
    fun listAllProducts():List<ProductResponseDto>{
        return productService.listAllProducts()
    }

    @PutMapping("{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody productRequestDto: ProductRequestDto
    ): ProductResponseDto{
        return productService.update(id, productRequestDto)
    }

//    @GetMapping("/{id}")
//    fun findUser(@PathVariable id: Long): ProductResponseDto{
//        return productService.findUser(id)
//    }
}