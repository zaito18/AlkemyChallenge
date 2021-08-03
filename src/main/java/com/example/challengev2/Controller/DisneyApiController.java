package com.example.challengev2.Controller;

import com.example.challengev2.Model.Actor;
import com.example.challengev2.Model.Movie;
import com.example.challengev2.Service.ActorServiceImpl;
import com.example.challengev2.Service.MovieServiceImpl;
import com.example.challengev2.Util.*;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DisneyApiController {

    private final ActorServiceImpl actorServiceImpl;
    private final MovieServiceImpl movieServiceImpl;

    @Autowired
    public DisneyApiController(ActorServiceImpl actorServiceImpl,MovieServiceImpl movieServiceImpl){
        this.actorServiceImpl=actorServiceImpl;
        this.movieServiceImpl=movieServiceImpl;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<ActorDTO>> getAllActorsDTO(@RequestParam MultiValueMap<String,String> params){
        return new ResponseEntity<>(actorServiceImpl.getAllActorsDTO(params),HttpStatus.OK);
    }

    @GetMapping("/characters/details")
    public ResponseEntity<List<ActorDTOII>> getAllActors(){
        return new ResponseEntity<>(actorServiceImpl.getAllActors(),HttpStatus.OK);
    }

    @PostMapping(value = "/characters/addCharacter")
    public ResponseEntity<Movie> addActor(@RequestBody Actor actor) {
        if (actorServiceImpl.addActor(actor)!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/characters/delete/{idActor}")
    public ResponseEntity<String> deleteActor(@PathVariable (value = "idActor") String idActor){
        actorServiceImpl.deleteActorById(idActor);
        if(actorServiceImpl.getActorById(idActor).size()==0) {
           return new ResponseEntity<>(idActor,HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/characters/update/{idActor}")
    public ResponseEntity<Long> updateActor(@PathVariable (value = "idActor") Long idActor,@RequestBody Actor actorDetails){
        if(actorServiceImpl.updateActor(idActor,actorDetails)!=null){
            return new ResponseEntity<>(idActor,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTOII>> getAllAMoviesDTOII(@RequestParam MultiValueMap<String,String> params){
        return new ResponseEntity<>(movieServiceImpl.getAllMoviesDTOII(params),HttpStatus.OK);
    }

    @GetMapping("/movies/details")
    public ResponseEntity<List<MovieDTOIII>> getAllMovies(){
        return new ResponseEntity<>(movieServiceImpl.getAllMovies(),HttpStatus.OK);
    }

    @PostMapping(value = "/movies/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        if(movieServiceImpl.addMovie(movie)!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }















}
