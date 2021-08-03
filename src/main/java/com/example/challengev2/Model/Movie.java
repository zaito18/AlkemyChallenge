package com.example.challengev2.Model;


import javax.persistence.*;
import java.util.*;

@Entity
public class Movie {

    private Long idMovie;
    private String urlImage;
    private String title;
    private Calendar creationDate;
    private String rating;
    private List<Actor> listOfActor;
    private List<Genre> listOfGenre;

    public Movie() {
        this.listOfActor=new ArrayList<Actor>();
        this.listOfGenre=new ArrayList<Genre>();
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @ManyToMany(mappedBy = "listOfMovies")
    public List<Actor> getListOfActor() {
        return listOfActor;
    }

    public void setListOfActor(List<Actor> listOfActor) {
        this.listOfActor = listOfActor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    @ManyToMany(mappedBy = "listOfMovies")
    public List<Genre> getListOfGenre() {
        return listOfGenre;
    }

    public void setListOfGenre(List<Genre> listOfGenre) {
        this.listOfGenre = listOfGenre;
    }
}
