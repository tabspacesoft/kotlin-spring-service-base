package com.tabspace.restkt.main.identities

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class IdentityDetails(
        private val identity: Identity
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val list = ArrayList<GrantedAuthority>()
        list.add(SimpleGrantedAuthority("ROLE_USER"))
        return list
    }

    override fun getPassword(): String {
        print(identity.password)
        return identity.password
    }

    override fun getUsername(): String {
        return identity.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}