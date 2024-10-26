package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.ProductRequestDto
import com.api_vendinha.api.domain.dtos.response.ProductResponseDto
import com.api_vendinha.api.domain.entities.Products
import com.api_vendinha.api.infrastructure.repository.ProductRepository
import com.api_vendinha.api.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
):ProductServiceInterface {
    override fun save(productRequestDto: ProductRequestDto): ProductResponseDto{
        var user = userRepository.findById(productRequestDto.user).orElseThrow();

        val products = productRepository.save(
            Products(
                price = productRequestDto.price,
                quantity = productRequestDto.quantity,
                user = user
            )
        )
        return ProductResponseDto(
            id = products.id,
            price = products.price,
            quantity = products.quantity,
            user = user
        )

    }
//    override fun findUser(id: Long): ProductResponseDto{
//        val product = productRepository.findById(id).orElseThrow{
//            IllegalArgumentException("Erro")
//        }
//        return ProductResponseDto(
//            id = product.id,
//            price = product.price,
//            quantity = product.quantity
//        )
//    }
//
//    override fun update(id: Long, productRequestDto: ProductRequestDto): ProductResponseDto{
//        val product = productRepository.findById(id).orElseThrow{
//            IllegalArgumentException("Erro")
//        }
//        product.quantity = productRequestDto.quantity
//        product.price = productRequestDto.price
//
//        val produtoUpdate = productRepository.save(product)
//
//        return ProductResponseDto(
//            id = produtoUpdate.id,
//            quantity = produtoUpdate.quantity,
//            price = produtoUpdate.price
//        )
//    }
}