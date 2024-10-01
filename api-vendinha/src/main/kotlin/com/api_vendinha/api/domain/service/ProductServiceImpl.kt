package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.ProductRequestDto
import com.api_vendinha.api.domain.dtos.response.ProductResponseDto
import com.api_vendinha.api.domain.entities.Products
import com.api_vendinha.api.infrastructure.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
):ProductServiceInterface {
    override fun save(productRequestDto: ProductRequestDto): ProductResponseDto{
//        val products = productRepository.save(
//            Products(
//                name = productRequestDto.name,
//                price = productRequestDto.price,
//                quantity = productRequestDto.quantity
//            )
//        )
//        return ProductResponseDto(
//            id = products.id,
//            name = products.name,
//            price = products.price,
//            quantity = products.quantity
//        )
        throw Exception("Function disable")
    }
    override fun findUser(id: Long): ProductResponseDto{
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("Erro")
        }
        return ProductResponseDto(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity
        )
    }

    override fun update(id: Long, productRequestDto: ProductRequestDto): ProductResponseDto{
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("Erro")
        }
        product.name = productRequestDto.name
        product.quantity = productRequestDto.quantity
        product.price = productRequestDto.price

        val produtoUpdate = productRepository.save(product)

        return ProductResponseDto(
            id = produtoUpdate.id,
            name = produtoUpdate.name,
            quantity = produtoUpdate.quantity,
            price = produtoUpdate.price
        )
    }
}