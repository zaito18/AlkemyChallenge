package com.example.challengev2.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Actor {


    private Long idActor;
    private String urlImage;
    private String name;
    private String age;
    private String weight;
    private String history;
    private Set<Movie> listOfMovies;

    public Actor() {
        this.listOfMovies = new HashSet<Movie>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdActor() {
        return idActor;
    }


    @JoinTable(name = "actor_movie",joinColumns = @JoinColumn(name = "id_actor", nullable = false),inverseJoinColumns = @JoinColumn(name="id_movie", nullable = false))
    @ManyToMany
    public Set<Movie> getListOfMovies() {
        return listOfMovies;
    }

    public void setListOfMovies(Set<Movie> listOfMovies) {
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


}
