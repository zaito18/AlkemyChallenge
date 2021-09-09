package com.example.challengev2.repository;
import com.example.challengev2.model.Movie;
import org.springframework.util.MultiValueMap;

import java.util.List;


public interface MovieRepository {

    List<Movie> findAllByFilter(MultiValueMap<String,String> params);
    void save(Movie movie);
    void delete(Movie movie);
    List<Movie> findAll();
    Movie getMovieById(Long id);

}
