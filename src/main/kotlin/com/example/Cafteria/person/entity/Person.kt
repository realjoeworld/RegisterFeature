package com.example.Cafteria.person.entity

import com.example.Cafteria.cafeteria.entity.Cafteria
import com.example.Cafteria.role.entity.Role

import jakarta.persistence.*

@Entity
@Table(
    name = "PEOPLE",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_people_email",
            columnNames = ["email"]
        )
    ]
)
class Person(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    var personId: Int? = null,

    @Column(
        name = "full_name",
        nullable = false
        )
 var fullName: String,

@Column(
    name = "phone",
    nullable = false,
)
 var phone: String,

@Column(
    name = "email",
    nullable = false
)
 var email: String,

@Column(
    name = "password",
    nullable = false
)
 var passwordHash: String,

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(
    name = "role_id",
    nullable = false
)
 var role: Role,

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(
    name = "cafeteria_id"
)
var cafeteria: Cafteria? = null
)