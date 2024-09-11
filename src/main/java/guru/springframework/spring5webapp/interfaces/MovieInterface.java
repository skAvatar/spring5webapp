package guru.springframework.spring5webapp.interfaces;

import guru.springframework.spring5webapp.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieInterface {

    Mono<Movie> findById(String id);

    Flux<Movie> findAll();

}
