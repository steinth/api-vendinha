package com.api_vendinha.api.infrastructure.repository

import com.api_vendinha.api.domain.entities.Sale
import org.springframework.data.repository.CrudRepository

interface SalesRepository: CrudRepository<Sale ,Long>