package org.acme.hibernate.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class Person {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
    lateinit var birth: LocalDate
    var isAlive: Boolean = true
}