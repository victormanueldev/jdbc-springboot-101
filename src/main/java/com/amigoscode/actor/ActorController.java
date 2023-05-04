package com.amigoscode.actor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/actors")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public Iterable<Actor> listActors() {
        return actorService.getActors();
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor) {
        return actorService.addNewActor(actor);
    }
}
