package com.tabspace.restkt.main.identities

import javax.persistence.*

@Entity
@Table(name = "identities")
data class Identity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "name", nullable = false)
    val name: String
)