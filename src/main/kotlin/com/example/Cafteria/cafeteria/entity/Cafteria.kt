package com.example.Cafteria.cafeteria.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "cafeteria")
class Cafteria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafeteria_id")
    var cafeteriaId: Int? = null,

    @Column(
        name = "name",
        nullable = false
        )
    var name: String,

    @Column(
        name = "phone",
        nullable = false
    )
    var phone: String

) {



}