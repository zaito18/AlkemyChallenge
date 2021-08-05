package com.example.challengev2.Service;

import com.example.challengev2.Model.Actor;
import com.example.challengev2.Model.Movie;
import com.example.challengev2.Util.MovieDTOII;
import com.example.challengev2.Util.MovieDTOIII;
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
