package com.amigoscode.actor;

import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor addNewActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public Iterable<Actor> getActors() {
        return this.actorRepository.findAll();
    }

}
