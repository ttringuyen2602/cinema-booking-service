package com.lynx.cinemabooking.entity;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
public class Film {
    Integer film_id;
    String film_name;
    String description;
    Integer duration_minutes;
    LocalDate release_date;
    String country;
    String director;
    String actor;
    String poster_path;

    public Film(ResultSet resultSet) throws SQLException {
        this.film_id = resultSet.getInt("film_id");
        this.film_name = resultSet.getString("film_name");
        this.description = resultSet.getString("description");
        this.duration_minutes = resultSet.getInt("duration_minutes");
        this.release_date = resultSet.getDate("release_date").toLocalDate();
        this.country = resultSet.getString("country");
        this.director = resultSet.getString("director");
        this.actor = resultSet.getString("actor");
        this.poster_path = resultSet.getString("poster_path");
    }
}
