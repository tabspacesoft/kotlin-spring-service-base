package com.tabspace.restkt.main.identities

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IdentityController(
        @Autowired
        val identityRepository: IdentityRepository
) {
    @GetMapping("/identities")
    fun getAllIdentities(): MutableList<Identity> {
        return identityRepository.findAll()
    }
}