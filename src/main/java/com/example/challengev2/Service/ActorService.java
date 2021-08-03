package com.example.challengev2.Service;

import com.example.challengev2.Model.Actor;
import com.example.challengev2.Util.ActorDTO;
import com.example.challengev2.Util.ActorDTOII;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ActorService {

    List<ActorDTO> getAllActorsDTO(MultiValueMap<String,String> params);

    List <ActorDTOII> getAllActors();

    Actor addActor(Actor actor);

    void deleteActorById(String id);

    List<Actor> getActorById(String id);

    Actor updateActor(Long idActor, Actor actorDetails);
}
