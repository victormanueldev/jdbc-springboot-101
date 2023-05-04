package com.amigoscode.mapper;

import com.amigoscode.actor.Actor;
import com.amigoscode.actor.ActorRef;
import com.amigoscode.movie.Movie;
import com.amigoscode.movie.dto.MovieCreationDTO;
import com.amigoscode.movie.dto.MovieDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Mapper {
    public MovieDTO toDto(Movie movie) {
        Integer id = movie.getId();
        String name = movie.getName();
        LocalDate releaseDate = movie.getReleaseDate();
        List<Integer> actors = movie.getActors().stream().map(ActorRef::getActor).toList();

        return new MovieDTO(id, name, releaseDate, actors);
    }

    public Movie toMovie(MovieCreationDTO movieDto) {
        return new Movie(movieDto.getName(), movieDto.getReleaseDate());
    }
}
