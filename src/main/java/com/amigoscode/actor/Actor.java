package com.amigoscode.actor;

import org.springframework.data.annotation.Id;

public class Actor {
    @Id
    private Integer id;
    private String name;


    public Actor(String name) {
        this.name = name;
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
}
