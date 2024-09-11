package guru.springframework.spring5webapp.Controller;

import guru.springframework.spring5webapp.domain.Movie;
import guru.springframework.spring5webapp.repositories.MovieRepository;
import guru.springframework.spring5webapp.services.MovieService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    Mono<Movie> getOne(@PathVariable String id){
        return movieService.findById(id);
    }

    @GetMapping
    Flux<Movie> getAll(){
        return movieService.findAll();
    }
}
