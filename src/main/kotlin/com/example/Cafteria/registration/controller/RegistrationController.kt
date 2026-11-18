package com.example.Cafteria.registration.controller

import com.example.Cafteria.registration.dto.RegisterRequest
import com.example.Cafteria.registration.dto.RegisterResponse
import com.example.Cafteria.registration.service.RegistrationService

import jakarta.validation.Valid

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth/register")
class RegistrationController(

    private val registrationService: RegistrationService

) {

    @PostMapping
    fun register(
        @Valid @RequestBody request: RegisterRequest
    ): ResponseEntity<RegisterResponse> {

        val response = registrationService.register(request)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }
}