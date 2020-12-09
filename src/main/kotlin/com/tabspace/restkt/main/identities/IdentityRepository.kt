package com.tabspace.restkt.main.identities

import org.springframework.data.jpa.repository.JpaRepository


interface IdentityRepository : JpaRepository<Identity, Long?> {
    fun findOneByEmail(email: String): Identity
}