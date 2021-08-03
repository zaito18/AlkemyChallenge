package com.example.challengev2.Model;

import javax.persistence.*;
import java.util.*;


@Entity

public class Actor {

    private Long idActor;
    private String urlImage;
    private String name;
    private String age;
    private String weight;
    private String history;
    private List<Movie> listOfMovies;

    public Actor() {
        this.listOfMovies = new ArrayList<Movie>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getIdActor() {
        return idActor;
    }


    @JoinTable(name = "actor_movie",joinColumns = @JoinColumn(name = "id_actor", nullable = false),inverseJoinColumns = @JoinColumn(name="id_movie", nullable = false))
    @ManyToMany
    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }


    public void setListOfMovies(List<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    public void setIdActor(Long id) {
        this.idActor = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return idActor.equals(actor.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor);
    }
}
