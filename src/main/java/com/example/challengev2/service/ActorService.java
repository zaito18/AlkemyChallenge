package com.example.challengev2.service;

import com.example.challengev2.model.Actor;
import com.example.challengev2.util.ActorDTO;
import com.example.challengev2.util.ActorDTOII;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ActorService {

    List<ActorDTO> getAllActorsDTO(MultiValueMap<String,String> params);

    List <ActorDTOII> getAllActors();

    Actor addActor(Actor actor);

    void deleteActorById(Long id);

    Actor getActorById(Long id);

    Actor updateActor(Long idActor, Actor actorDetails);
}
