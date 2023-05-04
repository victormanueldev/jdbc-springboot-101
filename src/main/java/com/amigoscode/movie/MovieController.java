package com.amigoscode.movie;

import com.amigoscode.actor.Actor;
import com.amigoscode.actor.ActorService;
import com.amigoscode.mapper.Mapper;
import com.amigoscode.movie.dto.MovieCreationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final ActorService actorService;
    private final Mapper mapper;

    public MovieController(MovieService movieService, ActorService actorService, Mapper mapper) {
        this.movieService = movieService;
        this.actorService = actorService;
        this.mapper = mapper;
    }

    @GetMapping
    public Iterable<Movie> listMovies() {
        return movieService.getMovies();
    }

//    @GetMapping("{id}")
//    public Movie getMovieId(@PathVariable("id") Integer id) {
//        return movieService.getMovie(id);
//    }

    @PostMapping
    public Movie addMovie(@RequestBody MovieCreationDTO movieDto) throws JsonProcessingException {
        Movie movie = mapper.toMovie(movieDto);
        movieDto.getActors()
                .stream()
                .map(Actor::new)
                .map(actorService::addNewActor)
                .forEach(movie::addActor);
        return movieService.addNewMovie(movie);
    }

//    @DeleteMapping("{id}")
//    public void deleteMovie(@PathVariable("id") Integer id) {
//        movieService.deleteMovie(id);
//    }

//    @PatchMapping("{id}")
//    public void updateMovie(@PathVariable("id") Integer id, @RequestBody Movie movie) {
//        movieService.updateMovie(id, movie);
//    }
}
