package com.example.challengev2.Repository;

import com.example.challengev2.Model.Actor;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import javax.transaction.Transactional;
import java.util.*;

@DataJpaTest
public class ActorRepositoryTests{

    @Autowired
    private ActorRepositoryImpl actorRepository;





    @Test
    @Transactional
    @Rollback
    public void queSePuedanRecuperarTodosLosPersonajesSegunAlgunFiltro(){
         givenUnActorPersistido();
         whenPidoTodosLosActoresConNombre("Dicaprio");
    }

    private void whenPidoTodosLosActoresConNombre(String nombre) {
        MultiValueMap<String, String> params = (MultiValueMap<String, String>) new ArrayListValuedHashMap();
        params.put("name", Collections.singletonList(nombre));
        actorRepository.findAllByFilter(params);

    }
    private void givenUnActorPersistido() {
        Actor actor = new Actor();
        actor.setName("Dicaprio");
        actor.setUrlImage("lsd3i5usakdjf3");
        actor.setAge("40");
        actor.setWeight("70");
        actor.setHistory("Actuo en titanic");
        actorRepository.saveActor(actor);

    }

}