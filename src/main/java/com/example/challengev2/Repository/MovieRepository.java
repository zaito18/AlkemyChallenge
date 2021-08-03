package com.example.challengev2.Repository;
import com.example.challengev2.Model.Movie;
import org.springframework.util.MultiValueMap;

import java.util.List;


public interface MovieRepository {

    List<Movie> findAllByFilter(MultiValueMap<String,String> params);
    Movie saveMovie(Movie movie);
    void deleteMovieById(Long id);
    List<Movie> findAll();
    List<Movie> findMovieById(Long id);

}
