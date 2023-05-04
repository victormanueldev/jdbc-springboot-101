package com.amigoscode.movie;

import com.amigoscode.actor.ActorRepository;
import com.amigoscode.actor.Actor;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie addNewMovie(Movie movie) {
        // TODO: Support many actors for one movie
        return movieRepository.save(movie);
    }

//    public void deleteMovie(Integer id) {
//        Optional<Movie> movies = movieRepository.selectMovieById(id);
//        movies.ifPresentOrElse(movie -> {
//            int result = movieRepository.deleteMovie(id);
//            if (result != 1) {
//                throw new IllegalStateException("oops could not delete movie");
//            }
//        }, () -> {
//            throw new NotFoundException(String.format("Movie with id %s not found", id));
//        });
//    }
//
//    public Movie getMovie(int id) {
//        return movieRepository.selectMovieById(id).orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
//    }
//
//    public void updateMovie(int id, Movie movie) {
//        Optional<Movie> movies = movieRepository.selectMovieById(id);
//        movies.ifPresentOrElse(m -> {
//            int result = movieRepository.updateMovie(id, movie);
//            if (result != 1) {
//                throw new NotFoundException("oops could not delete movie");
//            }
//        }, () -> {
//            throw new NotFoundException(String.format("Movie with id %s not found", id));
//        });
//    }
}
