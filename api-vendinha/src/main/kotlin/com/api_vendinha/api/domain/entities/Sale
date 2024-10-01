package com.api_vendinha.api.domain.entities

import jakarta.persistence.*

@Table(name = "sales")
@Entity
data class Sale (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    val id: Long? = null,

    @ManyToOne @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne @JoinColumn(name = "product_id")
    val product: Products,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "price")
    val price: Float

)