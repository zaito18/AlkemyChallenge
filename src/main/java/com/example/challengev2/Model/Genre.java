package com.example.challengev2.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Genre {

    private Long idGenre;
    private String name;
    private String urlImage;
    private Set<Movie> listOfMovies;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long id) {
        this.idGenre = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @OneToMany(cascade = CascadeType.DETACH,mappedBy = "genre")
    public Set<Movie> getListOfMovies() {
        return listOfMovies;
    }

    public void setListOfMovies(Set<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }
}
