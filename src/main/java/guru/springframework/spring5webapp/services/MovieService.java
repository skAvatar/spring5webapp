package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.Movie;
import guru.springframework.spring5webapp.domain.MovieEvent;
import guru.springframework.spring5webapp.interfaces.MovieInterface;
import guru.springframework.spring5webapp.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MovieService implements MovieInterface {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvents(String id) {
        return Flux.<MovieEvent>generate(  sink -> {
            sink.next(new MovieEvent(id, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }
}
