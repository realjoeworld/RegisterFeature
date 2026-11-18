package com.example.Cafteria.registration.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
data class RegisterRequest(

    @field:NotBlank(message = "Full name is required")
    val fullName: String,

    @field:NotBlank(message = "Phone number is required")
    val phone: String,

    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Please provide a valid email address")
    val email: String,

    @field:NotBlank(message = "Password is required")
    val password: String
)