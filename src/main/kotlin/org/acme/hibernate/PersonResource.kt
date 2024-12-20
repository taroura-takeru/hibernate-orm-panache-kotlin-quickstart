package org.acme.hibernate

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import org.acme.hibernate.entity.Person
import org.acme.hibernate.repository.PersonRepository
import java.time.LocalDate
import java.time.Month

class PersonResource {
    @Inject
    lateinit var personRepository: PersonRepository

    @GET
    fun count() = personRepository.count()
    // creating a person
    var person = Person()

    fun preparePerson() {
        person.name = "Stef"
        person.birth = LocalDate.of(1910, Month.FEBRUARY, 1)
        person.isAlive = true
    }

// persist it
    fun setPerson() {
        personRepository.persist(person)
    }

// note that once persisted, you don't need to explicitly save your entity: all
// modifications are automatically persisted on transaction commit.

// check if it's persistent
    fun deletePerson(){
        if(personRepository.isPersistent(person)){
            // delete it
            personRepository.delete(person)
        }
    }

    // getting a list of all Person entities
    val allPersons = personRepository.listAll()

// finding a specific person by ID
    fun findPersonById(personId:Long) {
        person = personRepository.findById(personId) ?: throw Exception("No person with that ID")
    }

    // finding all living persons
    val livingPersons = personRepository.list("isAlive", true)

    // counting all persons
    val countAll = personRepository.count()

    // counting all living persons
    val countAlive = personRepository.count("isAlive", true)

// delete all living persons
    fun deleteLivingPerson() {
        personRepository.delete("isAlive", true)
    }

// delete all persons
    fun deleteAllPerson() {
        personRepository.deleteAll()
    }

    // delete by id
    fun deletePersonById(personId:Long) {
        personRepository.deleteById(personId)
    }

// set the name of all living persons to 'Mortal'
    fun setLivingPersonName() {
        personRepository.update("name = 'Mortal' where status = ?1", true)
    }
}