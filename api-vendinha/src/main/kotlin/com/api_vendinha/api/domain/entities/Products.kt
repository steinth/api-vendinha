package com.api_vendinha.api.domain.entities

import jakarta.persistence.*

@Table(name = "Products")
@Entity
data class Products (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    val id: Long? = null,

    @Column(name = "nome")
    var name: String,

    @Column(name = "preco")
    var price:Float,

    @Column(name = "quantidade")
    var quantity: Int,

    @JoinColumn(name = "user_id")
    @ManyToOne
    var user: User
)