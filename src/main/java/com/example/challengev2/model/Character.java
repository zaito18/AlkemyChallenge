package com.example.challengev2.model;

import javax.persistence.*;
import java.util.*;


@Entity
public class Character {

    private Long idCharacter;
    private String urlImage;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private List<Movie> listOfMovies;

    public Character() {
        this.listOfMovies = new ArrayList<Movie>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getIdCharacter() {
        return idCharacter;
    }


    @JoinTable(name = "character_movie",joinColumns = @JoinColumn(name = "id_character", nullable = false),inverseJoinColumns = @JoinColumn(name="id_movie", nullable = false))
    @ManyToMany
    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }


    public void setListOfMovies(List<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    public void setIdCharacter(Long id) {
        this.idCharacter = id;
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



    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return idCharacter.equals(character.idCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCharacter);
    }
}
