package com.example.challengev2.repository;
import com.example.challengev2.model.Movie;
import org.springframework.util.MultiValueMap;

import java.util.List;


public interface MovieRepository {

    List<Movie> findAllByFilter(MultiValueMap<String,String> params);
    void saveMovie(Movie movie);
    void deleteMovieById(Long id);
    List<Movie> findAll();
    Movie findOneMovieById(Long id);

}
