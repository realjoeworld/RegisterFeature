package com.example.Cafteria.registration.service

import com.example.Cafteria.registration.dto.RegisterRequest
import com.example.Cafteria.registration.dto.RegisterResponse

import com.example.Cafteria.person.entity.Person
import com.example.Cafteria.person.repository.PersonRepository

import com.example.Cafteria.role.repository.RoleRepository

import com.example.Cafteria.exception.EmailAlreadyExistsException

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegistrationService(

    private val personRepository: PersonRepository,

    private val roleRepository: RoleRepository,

    private val passwordEncoder: PasswordEncoder

) {

    @Transactional
    fun register(request: RegisterRequest): RegisterResponse {

        val normalizedEmail = request.email.lowercase()

        if (personRepository.existsByEmailIgnoreCase(normalizedEmail)) {
            throw EmailAlreadyExistsException(
                "Email already registered"
            )
        }

        val customerRole = roleRepository.findByRoleName("CUSTOMER")
            ?: throw IllegalStateException(
                "CUSTOMER role is not configured in the database"
            )

        val hashedPassword = passwordEncoder.encode(request.password)!!

        val person = Person(

            fullName = request.fullName.trim(),

            phone = request.phone.trim(),

            email = normalizedEmail,

            passwordHash = hashedPassword,

            role = customerRole,

            cafeteria = null
        )

        val savedPerson = personRepository.save(person)

        return RegisterResponse(
            personId = requireNotNull(savedPerson.personId),
            fullName = savedPerson.fullName,
            email = savedPerson.email,
            roleName = savedPerson.role.roleName
        )
    }
}