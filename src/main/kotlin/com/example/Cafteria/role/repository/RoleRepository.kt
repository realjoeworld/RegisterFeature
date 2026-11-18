package com.example.Cafteria.role.repository

import com.example.Cafteria.role.entity.Role

import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Int> {

    fun findByRoleName(roleName: String): Role?
}