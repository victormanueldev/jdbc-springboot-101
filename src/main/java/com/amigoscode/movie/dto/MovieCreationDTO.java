package com.amigoscode.movie.dto;

import com.amigoscode.actor.Actor;
import com.amigoscode.movie.Movie;

import java.time.LocalDate;
import java.util.List;

public class MovieCreationDTO {
    private String name;
    private LocalDate releaseDate;
    private List<String> actors;

    public MovieCreationDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }
}
