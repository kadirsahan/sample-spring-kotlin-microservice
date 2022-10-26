package pl.piomin.services.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import pl.piomin.services.model.Person
import pl.piomin.services.repository.PersonRepository

@RestController
@RequestMapping("/persons")
class PersonController(val repository: PersonRepository) {

    val log: Logger = LoggerFactory.getLogger(PersonController::class.java)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Person? {
        log.info("findById({})", id)
        return repository.findById(id)
    }

    @GetMapping("/ages/{age}")
    fun findByAge(@PathVariable age: Int): List<Person> {
        log.info("findByAge({})", age)
        return repository.findByAge(age)
    }

    @GetMapping
    fun findAll(): List<Person> = repository.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @PutMapping
    fun update(@RequestBody person: Person): Person = repository.update(person)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int): Boolean = repository.removeById(id)

}
