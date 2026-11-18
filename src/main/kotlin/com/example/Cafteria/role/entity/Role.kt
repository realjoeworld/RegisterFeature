package com.example.Cafteria.role.entity
import jakarta.persistence.*

@Entity
@Table(name = "roles")
class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    var roleId: Int? = null,

    @Column(
        name = "role_name",
        nullable = false,
        unique = true
        )
        var roleName: String

)