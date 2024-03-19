package com.lynx.cinemabooking.dao;

import com.lynx.cinemabooking.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    FilmDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Film> getShowingMoviesList() {
        final String sql = "SELECT film_name, poster_path FROM film";
        return jdbcTemplate.query(sql, (rs, i) -> new Film(rs));
    }
}
