package com.example.Cafteria.person.repository

import com.example.Cafteria.person.entity.Person

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Int> {

    fun existsByEmailIgnoreCase(email: String): Boolean
}