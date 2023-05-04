CREATE TABLE actor
(
    id    bigserial primary key,
    name  TEXT NOT NULL,
    unique (name)
);

CREATE TABLE movie_to_actor
(
    movie bigint REFERENCES movie (id),
    actor bigint REFERENCES actor (id)
)