package com.amigoscode.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        String sql = """
                SELECT id, name, release_date
                FROM movie
                LIMIT 10;
                """;

        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        String sql = """
                 INSERT INTO movie(name, release_date)
                 VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, movie.name(), movie.releaseDate());
    }

    @Override
    public int deleteMovie(int id) {
        String sql = """
                DELETE FROM movie
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        String sql = """
                SELECT id, name, release_date
                FROM movie
                WHERE id = ?
                """;
        List<Movie> movies = jdbcTemplate.query(sql, new MovieRowMapper(), id);
        return movies.stream().findFirst();
    }

    @Override
    public int updateMovie(int id, Movie movie) {
        String sql = """
                UPDATE movie
                SET name = ?, release_date = ?
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, movie.name(), movie.releaseDate(), id);
    }
}
