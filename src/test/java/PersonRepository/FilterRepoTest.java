package PersonRepository;

import guru.springframework.spring5webapp.domain.Person;
import guru.springframework.spring5webapp.repositories.PersonRepositoryImpl;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FilterRepoTest {

    PersonRepositoryImpl personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    public void findByIdTest() {
        Mono<Person> personMono = personRepository.findById(1);
        Person person = personMono.block();
        System.out.println(person.toString());

    }

    @Test
    void monoTest() {
        Mono<Person> personMono = personRepository.findById(1);

        StepVerifier.create(personMono)
                .expectNextCount(1).verifyComplete();



        personMono.subscribe(System.out::println);



    }

    @Test
    void fluxTest() {
        Flux<Person> personFlux = personRepository.findAll();
        personFlux.subscribe(p -> {
            System.out.println(p.toString());
        });
    }

    @Test
    void filterTest() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<Person> personMono = personFlux.filter(person ->
                person.getId().equals(4)
        ).next();
        personMono.subscribe(p -> {
            System.out.println(p.toString());
        });
    }

    @Test
    void filterNotFoundTest() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<Person> personMono = personFlux.filter(person ->
                person.getId().equals(0)
        ).next();
        personMono.subscribe(p -> {
            System.out.println(p.toString());
        });
    }

    @Test
    void filterNotFoundTestException() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<Person> personMono = personFlux.filter(person ->
                person.getId().equals(0)
        ).single();

        personMono.doOnError(error -> {
            System.out.println("Error");
        }).onErrorReturn(
                Person.builder().build())
        .subscribe(p -> {
            System.out.println(p.toString());
        });
    }


}
