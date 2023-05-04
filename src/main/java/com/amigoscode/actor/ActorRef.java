package com.amigoscode.actor;

import org.springframework.data.relational.core.mapping.Table;

@Table("movie_to_actor")
public class ActorRef {
    private Integer actor;

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }
}
