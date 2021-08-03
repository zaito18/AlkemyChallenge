package com.example.challengev2.Service;

import com.example.challengev2.Model.Actor;
import com.example.challengev2.Model.Movie;
import com.example.challengev2.Repository.MovieRepositoryImpl;
import com.example.challengev2.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepositoryImpl movieRepositoryImpl;

    @Autowired
    public MovieServiceImpl(MovieRepositoryImpl movieRepositoryImpl){
        this.movieRepositoryImpl=movieRepositoryImpl;
    }


    @Override
    public List<MovieDTOII> getAllMoviesDTOII(MultiValueMap<String, String> params) {
            List<Movie> listToIterate = movieRepositoryImpl.findAllByFilter(params);
            List<MovieDTOII> listToReturn=new ArrayList<>();
            for (Movie aux:listToIterate){
                MovieDTOII movieDTOII = new MovieDTOII(aux.getUrlImage(),aux.getTitle(),aux.getCreationDate());
                listToReturn.add(movieDTOII);
            }
            return listToReturn;
        }

    @Override
    public List<MovieDTOIII> getAllMovies() {

        List<Movie> listToIterate = movieRepositoryImpl.findAll();
        List<MovieDTOIII> listToReturn = new ArrayList<>();
        for (Movie aux:listToIterate){
            List<ActorDTOII> listOfActor = iteration(aux.getListOfActor());
            MovieDTOIII movieDTOIII = new MovieDTOIII(aux.getUrlImage(),aux.getTitle(),aux.getCreationDate(),aux.getRating());
            movieDTOIII.setListOfActor(listOfActor);
            listToReturn.add(movieDTOIII);
        }
        return listToReturn;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepositoryImpl.saveMovie(movie);
    }

    private List<ActorDTOII> iteration(List<Actor> list){
        List<ActorDTOII> listOfActor = new ArrayList<>();
        for(Actor aux:list){
            ActorDTOII actor = new ActorDTOII(aux.getUrlImage(),aux.getName(),aux.getAge(),aux.getWeight(),aux.getHistory());
            listOfActor.add(actor);
        }
        return listOfActor;
    }


}
