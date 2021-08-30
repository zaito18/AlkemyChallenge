package com.example.challengev2.service;

import com.example.challengev2.model.Movie;
import com.example.challengev2.util.MovieDTOII;
import com.example.challengev2.util.MovieDTOIII;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface MovieService {
     List<MovieDTOII> getAllMoviesDTOII(MultiValueMap<String, String> params);

    List<MovieDTOIII> getAllMovies();

    Movie addMovie(Movie movie);

    void deleteMovieById(Long id);

    Movie getMovieById(Long id);

    Movie updateMovie(Long idMovie, Movie movieDetails);

}
