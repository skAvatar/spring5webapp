package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
