package com.example.Cafteria.registration.dto

data class RegisterResponse(

    val personId: Int,

    val fullName: String,

    val email: String,

    val roleName: String
)