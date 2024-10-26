package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.response.SaleResponseDto
import com.api_vendinha.api.domain.entities.Sale
import com.api_vendinha.api.infrastructure.repository.ProductRepository
import com.api_vendinha.api.infrastructure.repository.SalesRepository
import com.api_vendinha.api.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class SaleServiceImpl (
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
    private val salesRepository: SalesRepository
): SaleServiceInterface{
    override fun processSale(userId: Long, productId: Long, quantity: Int): SaleResponseDto {
        val products = productRepository.findById(productId).orElseThrow{ Exception("produto não encontrado")}
        val user = userRepository.findById(userId).orElseThrow{Exception("usuario não encontrado")}

        if(products.quantity < quantity){
            throw Exception("Estoque insuficiente")
        }
            products.quantity -= quantity
            productRepository.save(products)

            val sale = Sale(
                user = user,
                product = products,
                quantity = quantity,
                price = products.price)
            salesRepository.save(sale)
            return SaleResponseDto(
                userId = user.id!!,
                productId = products.id!!,
                quantity = sale.quantity,
                totalPrice = sale.quantity * products.price
            )
    }
}