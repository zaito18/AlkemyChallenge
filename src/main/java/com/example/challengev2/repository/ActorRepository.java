package com.example.challengev2.repository;

import com.example.challengev2.model.Actor;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ActorRepository{

    List<Actor> findAllByFilter(MultiValueMap<String,String> params);
    void saveActor(Actor actor);
    void deleteActorById(Long id);
    List<Actor> findAll();
    Actor findActorById(Long id);
    Actor findOneActorById(Long idActor);
}
