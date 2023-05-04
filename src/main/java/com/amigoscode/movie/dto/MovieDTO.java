package com.amigoscode.movie.dto;

import com.amigoscode.actor.Actor;

import java.time.LocalDate;
import java.util.List;

public class MovieDTO {

    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private List<Integer> actors;

    public MovieDTO(Integer id, String name, LocalDate releaseDate, List<Integer> actors) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Integer> getActors() {
        return actors;
    }

    public void setActors(List<Integer> actors) {
        this.actors = actors;
    }
}
