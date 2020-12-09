package com.tabspace.restkt.main.config

import com.tabspace.restkt.main.identities.Identity
import com.tabspace.restkt.main.identities.IdentityDetails
import com.tabspace.restkt.main.identities.IdentityRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
open class CustomUserDetailService(
        private val identityRepository: IdentityRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val identity: Identity = identityRepository.findOneByEmail(username);
        return IdentityDetails(identity)
    }
}