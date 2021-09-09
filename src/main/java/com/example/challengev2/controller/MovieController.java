package com.example.challengev2.controller;

import com.example.challengev2.service.MovieServiceImpl;
import com.example.challengev2.util.MovieDTO;
import com.example.challengev2.util.MovieDTOII;
import com.example.challengev2.util.MovieDTOIII;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MovieController {

    private final MovieServiceImpl movieServiceImpl;

    @Autowired
    public MovieController(MovieServiceImpl movieServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
    }


    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTOII>> getAllAMoviesDTOII(@RequestParam MultiValueMap<String,String> params){
        return new ResponseEntity<>(movieServiceImpl.getAllMoviesDTOII(params), HttpStatus.OK);
    }

    @GetMapping("/movies/details")
    public ResponseEntity<List<MovieDTOIII>> getAllMovies(){
        return new ResponseEntity<>(movieServiceImpl.getAllMovies(),HttpStatus.OK);
    }

    @PostMapping(value = "/movies/save")
    public ResponseEntity<?> save(@RequestBody MovieDTO movie){
            movieServiceImpl.save(movie);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete/{idMovie}")
    public ResponseEntity<?> delete(@PathVariable (value = "idMovie") Long idMovie){
        movieServiceImpl.delete(idMovie);
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/movies/update/{idMovie}")
    public ResponseEntity<?> updateMovie(@PathVariable (value = "idMovie") Long idMovie,@RequestBody MovieDTO movieDetails){
        movieServiceImpl.update(idMovie,movieDetails);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}
