package com.example.challengev2.Repository;

import static org.assertj.core.api.Assertions.*;

import com.example.challengev2.Model.Actor;
import com.example.challengev2.Model.Genre;
import com.example.challengev2.Model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.*;

@DataJpaTest
public class MovieRepositoryTest {


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private GenreRepository genreRepository;


    @Test
    @Transactional
    @Rollback
    public void thatAMovieCanBePersisted(){
       Genre genreOfTheMovie=givenAGenre("Fantasy","URLImage");
       Actor actorSelectedForTheMovie=givenACharacter("www.img.com/personajeImg","Shrek","30","300","a great character");
       Calendar date = givenADate();
       String rating = givenARating("3");
       Movie movieToSave=givenAMovie("www.image.com/url","Shrek tercero",date,rating,actorSelectedForTheMovie,genreOfTheMovie);
       Movie saved=whenAMovie(movieToSave);
       thenVerifiyTheSavedMovie(movieToSave,saved);
    }

    private void thenVerifiyTheSavedMovie(Movie movieToSave, Movie saved) {
        assertThat(saved.getIdMovie()).isEqualTo(movieToSave.getIdMovie());
    }

    private Movie whenAMovie(Movie movieToSave) {
        return movieRepository.save(movieToSave);
    }

    private Movie givenAMovie(String urlImage, String title, Calendar date, String rating, Actor actorSelectedForTheMovie, Genre genreOfTheMovie) {
        Movie movie = new Movie();
        Set<Actor> myList = new HashSet<Actor>();
        myList.add(actorSelectedForTheMovie);
        Set<Genre> myList2 =  new HashSet<Genre>();
        myList2.add(genreOfTheMovie);
        movie.setTitle(title);
        movie.setCreationDate(date);
        movie.setRating(rating);
        movie.setListOfActor((Set<Actor>) myList);
        movie.setListOfGenre((Set<Genre>) myList2);
        return movie;
    }

    private String givenARating(String i) {
        return i;
    }

    private Calendar givenADate() {
        Calendar creationDate = Calendar.getInstance();
        creationDate.set(Calendar.YEAR, 1990);
        creationDate.set(Calendar.MONTH, Calendar.APRIL);
        creationDate.set(Calendar.DATE, Calendar.WEDNESDAY);
        return creationDate;
    }

    private Actor givenACharacter(String url, String name, String age, String weight, String history) {
        Actor c = new Actor();
        c.setUrlImage(url);
        c.setName(name);
        c.setAge(age);
        c.setWeight(weight);
        c.setHistory(history);
        actorRepository.save(c);
        return c;
    }

    private Genre givenAGenre(String genre, String urlImage) {
        Genre newGenre = new Genre();
        newGenre.setName(genre);
        newGenre.setUrlImage(urlImage);
        genreRepository.save(newGenre);
        return newGenre;
    }

}
