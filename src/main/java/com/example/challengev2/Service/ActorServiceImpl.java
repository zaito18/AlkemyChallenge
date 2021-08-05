package com.example.challengev2.Service;

import com.example.challengev2.Model.Actor;

import com.example.challengev2.Model.Movie;
import com.example.challengev2.Repository.ActorRepositoryImpl;
import com.example.challengev2.Util.ActorDTO;
import com.example.challengev2.Util.ActorDTOII;
import com.example.challengev2.Util.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {

    private final ActorRepositoryImpl actorRepositoryImpl;

    @Autowired
    public ActorServiceImpl(ActorRepositoryImpl actorRepositoryImpl){
        this.actorRepositoryImpl=actorRepositoryImpl;
    }

    @Override
    public List<ActorDTO> getAllActorsDTO(MultiValueMap<String,String> params) {
        List<Actor> listToIterate =  actorRepositoryImpl.findAllByFilter(params);
        List<ActorDTO> listToReturn=new ArrayList<>();
        for (Actor aux:listToIterate){
            ActorDTO actorDTO = new ActorDTO(aux.getUrlImage(),aux.getName());
            listToReturn.add(actorDTO);
        }
        return listToReturn;
    }

    @Override
    public List<ActorDTOII> getAllActors() {

        List<Actor> listToIterate = actorRepositoryImpl.findAll();
        List<ActorDTOII> listToReturn = new ArrayList<>();
        for (Actor aux:listToIterate){
            List<MovieDTO> listOfMovies = iteration(aux.getListOfMovies());
            ActorDTOII actorDTOII = new ActorDTOII(aux.getUrlImage(),aux.getName(),aux.getAge(),aux.getWeight(),aux.getHistory());
            actorDTOII.setListOfMovies(listOfMovies);
            listToReturn.add(actorDTOII);
        }
        return listToReturn;
    }

    private List<MovieDTO> iteration(List<Movie> list){
        List<MovieDTO> listOfMovies = new ArrayList<>();
        for(Movie aux:list){
            MovieDTO movie = new MovieDTO(aux.getUrlImage(),aux.getTitle(),aux.getCreationDate(),aux.getRating());
            listOfMovies.add(movie);
        }
        return listOfMovies;
    }

    @Override
    public Actor addActor(Actor actor) {
        actorRepositoryImpl.saveActor(actor);
        return actorRepositoryImpl.findOneActorById(actor.getIdActor());
    }

    @Override
    public void deleteActorById(Long id) {
        actorRepositoryImpl.deleteActorById(id);
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepositoryImpl.findOneActorById(id);
    }

    @Override
    public Actor updateActor(Long idActor, Actor actorDetails) {
        Actor actor = actorRepositoryImpl.findOneActorById(idActor);

        actor.setUrlImage(actorDetails.getUrlImage());
        actor.setName(actorDetails.getName());
        actor.setAge(actorDetails.getAge());
        actor.setWeight(actorDetails.getWeight());
        actor.setHistory(actorDetails.getHistory());
        return addActor(actor);
    }


}

