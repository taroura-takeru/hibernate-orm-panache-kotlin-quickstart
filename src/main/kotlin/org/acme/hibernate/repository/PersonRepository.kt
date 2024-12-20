package org.acme.hibernate.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.acme.hibernate.entity.Person

@ApplicationScoped
class PersonRepository: PanacheRepository<Person> {
    fun findByName(name: String) = find("name", name).firstResult()
    fun findAlive() = list("isAlive", true)
    fun deleteStefs() = delete("name", "Stef")
}