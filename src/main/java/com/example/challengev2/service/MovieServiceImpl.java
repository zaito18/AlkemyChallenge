package com.example.challengev2.service;

import com.example.challengev2.model.Character;
import com.example.challengev2.model.Movie;
import com.example.challengev2.repository.MovieRepositoryImpl;
import com.example.challengev2.util.*;
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
            List<CharacterDTOII> listOfActor = iteration(aux.getListOfActor());
            MovieDTOIII movieDTOIII = new MovieDTOIII(aux.getUrlImage(),aux.getTitle(),aux.getCreationDate(),aux.getRating());
            movieDTOIII.setListOfActor(listOfActor);
            listToReturn.add(movieDTOIII);
        }
        return listToReturn;
    }

    @Override
    public void save(MovieDTO movieDTO) {

        if((movieDTO.getTitle()==null || movieDTO.getTitle().isBlank()) || movieDTO.getCreationDate()==null || (movieDTO.getUrlImage()==null || movieDTO.getUrlImage().isBlank()) || movieDTO.getRating()==null ){
            throw  new IncompleteOrIncompatibleOrNullFieldsException("Incomplete/incompatible or null fields");
        }
        else {
            Movie movie = new Movie();
            movie.setUrlImage(movieDTO.getUrlImage());
            movie.setRating(movieDTO.getRating());
            movie.setTitle(movieDTO.getTitle());
            movie.setCreationDate(movieDTO.getCreationDate());
            movieRepositoryImpl.save(movie);
        }
    }


    @Override
    public void delete(Long id) {
        if(getMovieById(id)==null){
            throw  new TheCharacterDoesNotExistException("The character does not exist");
        }
        movieRepositoryImpl.delete(getMovieById(id));
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepositoryImpl.getMovieById(id);
    }

    @Override
    public void update(Long idMovie, MovieDTO movieDetails) {
        if(movieRepositoryImpl.getMovieById(idMovie) != null) {
            if((movieDetails.getUrlImage()==null || movieDetails.getUrlImage().isBlank()) || movieDetails.getRating()==null || (movieDetails.getTitle()==null || movieDetails.getTitle().isBlank()) || movieDetails.getCreationDate()==null){
                throw  new IncompleteOrIncompatibleOrNullFieldsException("Incomplete/incompatible or null fields");
            }
            Movie movie = movieRepositoryImpl.getMovieById(idMovie);
            movie.setUrlImage(movieDetails.getUrlImage());
            movie.setRating(movieDetails.getRating());
            movie.setTitle(movieDetails.getTitle());
            movie.setCreationDate(movieDetails.getCreationDate());
            movieRepositoryImpl.save(movie);
        }else {
            throw new TheCharacterDoesNotExistException("The character does not exist");
        }
    }

    private List<CharacterDTOII> iteration(List<Character> list){
        List<CharacterDTOII> listOfActor = new ArrayList<>();
        for(Character aux:list){
            CharacterDTOII actor = new CharacterDTOII(aux.getUrlImage(),aux.getName(),aux.getAge(),aux.getWeight(),aux.getHistory());
            listOfActor.add(actor);
        }
        return listOfActor;
    }


}
