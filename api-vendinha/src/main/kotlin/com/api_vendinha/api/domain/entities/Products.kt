package com.api_vendinha.api.domain.entities

import jakarta.persistence.*

@Table(name = "Products")
@Entity
data class Products (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    val id: Long? = null,

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "price")
    var price:Float,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null
)