package com.lynx.cinemabooking.controller;

import com.lynx.cinemabooking.dao.FilmDAO;
import com.lynx.cinemabooking.entity.Film;
import com.lynx.cinemabooking.service.FilmService;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Log
@RestController
public class FilmController {
    FilmService filmService;
    FilmDAO filmDAO;

    @Autowired
    FilmController(FilmService filmService, FilmDAO filmDAO) {
        this.filmService = filmService;
        this.filmDAO = filmDAO;
    }

    @GetMapping("/phim-dang-chieu")
    ResponseEntity<List<Film>> getShowingMoviesList() {
        try {
            return ResponseEntity.ok(filmDAO.getShowingMoviesList());
        } catch (Exception e) {
            log.log(Level.WARNING, "FilmController >> /phim-dang-chieu >> SQL Exception");
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/phim-dang-chieu1")
    ResponseEntity<Object> getFilmDetail() {
        return ResponseEntity.ok("");
    }
}
