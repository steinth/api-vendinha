package com.api_vendinha.api.domain.service

import com.api_vendinha.api.domain.dtos.request.ProductRequestDto
import com.api_vendinha.api.domain.dtos.response.ProductResponseDto
import com.api_vendinha.api.domain.dtos.response.UserResponseDto
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
        val user = userRepository.findById(productRequestDto.user).orElseThrow();

        val products = productRepository.save(
            Products(
                name = productRequestDto.name,
                price = productRequestDto.price,
                quantity = productRequestDto.quantity,
                user = user
            )
        )
        return ProductResponseDto(
            id = products.id,
            name = products.name,
            price = products.price,
            quantity = products.quantity,
            user = UserResponseDto(
                id = user.id,
                name = user.name,
                email = user.email,
                password = user.password,
                cpf_cnpj = user.cpf_cnpj,
                is_active = user.is_active,
            )
        )

    }

    override fun update(id: Long, productRequestDto: ProductRequestDto): ProductResponseDto{
        val userProduct = userRepository.findById(productRequestDto.user).orElseThrow();
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("Erro")
        }
        product.user = userProduct
        product.name = productRequestDto.name
        product.quantity = productRequestDto.quantity
        product.price = productRequestDto.price

        val produtoUpdate = productRepository.save(product)

        return ProductResponseDto(
            id = produtoUpdate.id,
            name = produtoUpdate.name,
            quantity = produtoUpdate.quantity,
            price = produtoUpdate.price,
            user = UserResponseDto(
                id = userProduct.id,
                name = userProduct.name,
                email = userProduct.email,
                password = userProduct.password,
                cpf_cnpj = userProduct.cpf_cnpj,
                is_active = userProduct.is_active
            )
        )
    }

    override fun listAllProducts():List<ProductResponseDto>{
        val allProducts = productRepository.findAll()
        return allProducts.map { product ->
            ProductResponseDto(
                id = product.id,
                price = product.price,
                quantity = product.quantity,
                user = UserResponseDto(

                )
            )
        }

    }

//    override fun findUser(id: Long): ProductResponseDto{
//       val product = productRepository.findById(id).orElseThrow{
//            IllegalArgumentException("Erro")
//        }
//        return ProductResponseDto(
//            id = product.id,
//            price = product.price,
//            quantity = product.quantity
//        )
//    }



//
}