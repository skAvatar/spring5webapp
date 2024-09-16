package guru.springframework.spring5webapp.interfaces;

import guru.springframework.spring5webapp.domain.Movie;
import guru.springframework.spring5webapp.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieInterface {

    Mono<Movie> findById(String id);

    Flux<Movie> findAll();

    Flux<MovieEvent> streamMovieEvents(String id);

}
