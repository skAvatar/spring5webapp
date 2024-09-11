package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    Person michael = new Person(1, "Michael", "Weston");
    Person fiona = new Person(2, "Fiona", "Glenn");
    Person enrique = new Person(3, "Enrique", "Marin");
    Person aranza = new Person(4, "Aranza", "Sanchez");

    @Override
    public Mono<Person> findById(Integer id) {
        return findAll().filter(person ->
            person.getId().equals(id)
        ).single()
        .onErrorReturn(
            Person.builder().build()
        );
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael, fiona, enrique, aranza);
    }
}
