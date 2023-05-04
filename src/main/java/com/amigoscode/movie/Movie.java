package com.amigoscode.movie;

import com.amigoscode.actor.Actor;
import com.amigoscode.actor.ActorRef;
import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Movie {
    @Id
    private Integer id;
    private String name;
    private LocalDate releaseDate;

    private Set<ActorRef> actors = new HashSet<>();

    public Movie(String name, LocalDate releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;

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

    public void addActor(Actor actor) {
        this.actors.add(this.createActorRef(actor));
    }

    private ActorRef createActorRef(Actor actor) {
        Assert.notNull(actor, "Actor must not be null");
        Assert.notNull(actor.getId(), "Actor id, must not be null");

        ActorRef actorRef = new ActorRef();
        actorRef.setActor(actor.getId());
        return actorRef;
    }

    public Set<ActorRef> getActors() {
        return actors;
    }
}
