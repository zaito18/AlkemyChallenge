package com.example.challengev2.Repository;


import com.example.challengev2.Model.Actor;
import com.example.challengev2.Model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class ActorRepositoryTests {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    @Rollback
    @Transactional
    public void thatAActorCanBePersisted(){
        Actor actor = givenAActor("www.example.com/img","Homer","40","90","the best");
        Long idActor=whenSaveTheActor(actor);
        thenActorExists(idActor);
    }

    @Test
    @Rollback
    @Transactional
    public void thatAActorCanBeFinded(){
        Long actorId = givenAActor2("www.example.com/img","Marge","36","60","the women");
        Optional<Actor> actor =whenFindTheActor(actorId);
        thenVerifyTheName(actor);
    }

    @Test
    @Rollback
    @Transactional
    public void thatAActorCanBeMod(){
        Long actor = givenAActor2("www.example.com/img","Bart","40","50","the dumb");
        Optional<Actor> actor1 = whenModTheActor(actor);
        thenVerifyTheNewName(actor1);
    }

    @Test
    @Rollback
    @Transactional
    public void thatAActorCanBeDelete(){
        Long actor = givenAActor2("www.example.com/img","Homer","40","90","the best");
        Actor actor1=whenDeleteTheActor(actor);
        thenVerifyThatTheActorNotExists(actor1);
    }

    private void thenVerifyThatTheActorNotExists(Actor actor1) {
        assertThat(actor1).isNull();
    }

    private Actor whenDeleteTheActor(Long idActor) {
       actorRepository.deleteById(idActor);
       Actor actor1=null;
       Optional<Actor> actorUno=actorRepository.findByHistory("the best");
       if(actorUno.isPresent()) actor1=actorUno.get();
       return actor1;
    }

    private void thenVerifyTheNewName(Optional<Actor> actor1) {
        assertThat(actor1.get().getAge()).isEqualTo("13");
        assertThat(actor1).isPresent();
    }

    private Optional<Actor> whenModTheActor(Long idActor) {
        Optional<Actor> actor= actorRepository.findById(idActor);
        actor.get().setAge("13");
        actorRepository.save(actor.get());
        return actor;
    }


    private void thenVerifyTheName(Optional<Actor> actor) {
        assertThat("Marge").isEqualTo(actor.get().getName());
        assertThat(actor).isPresent();
    }

    private Optional<Actor> whenFindTheActor(Long id) {
       Optional<Actor> actor = actorRepository.findById(id);
       return actor;
    }

    private void thenActorExists(Long actor) {
        Optional<Actor> a=actorRepository.findById(actor);
        assertThat(a).isPresent();
    }

    private Long whenSaveTheActor(Actor actor) {
        Actor a = actorRepository.save(actor);
        return a.getIdActor();
    }

    private Actor givenAActor(String urlImage, String name, String age, String weight, String history) {
        Actor c = new Actor();
        c.setUrlImage(urlImage);
        c.setName(name);
        c.setAge(age);
        c.setWeight(weight);
        c.setHistory(history);
        return c;
    }

    private Long givenAActor2(String urlImage, String name, String age, String weight, String history) {
        Actor c = new Actor();
        c.setUrlImage(urlImage);
        c.setName(name);
        c.setAge(age);
        c.setWeight(weight);
        c.setHistory(history);
        return  whenSaveTheActor(c);
    }





    /*private Movie givenAMovie(String urlImage,String title) {
        Calendar creationDate = Calendar.getInstance();
        creationDate.set(Calendar.YEAR, 1990);
        creationDate.set(Calendar.MONTH, Calendar.APRIL);
        creationDate.set(Calendar.DATE, Calendar.WEDNESDAY);
        Integer numberRating = 3;
        Rating rating = new Rating(numberRating);
        Movie movie = new Movie("urlImage", "title", creationDate,rating);
        return movie;
    }
   */

}
