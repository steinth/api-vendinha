package com.api_vendinha.api.infrastructure.repository

import com.api_vendinha.api.domain.entities.Products
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Products, Long>