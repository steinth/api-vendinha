package com.api_vendinha.api.domain.entities

import jakarta.persistence.*

@Table(name = "users")
@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    val id: Long? = null, // O id pode ser nulo inicialmente antes de ser atribuído pelo banco de dados.

    @Column(name = "name")
    var name: String, // O nome do usuário é uma string não nula.

    @Column(name = "email")
    var email:String,

    @Column(name = "password")
    var password: String,

    @Column(name = "cpf_cnpj")
    var cpf_cnpj: String,

    @Column(name = "is_active")
    var is_active: Boolean,

    @OneToMany(mappedBy = "user")
    var product: List<Products>? = arrayListOf()
)
