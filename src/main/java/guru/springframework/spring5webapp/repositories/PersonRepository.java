package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> findById(Integer id);

    Flux<Person> findAll();
}
