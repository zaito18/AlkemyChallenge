package com.example.challengev2.Model;


import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {


    private Long idMovie;
    private String urlImage;
    private String title;
    private Calendar creationDate;
    private String rating;
    private Set<Actor> listOfActor;
    private Genre genre;

    public Movie() {
        this.listOfActor=new HashSet<Actor>();
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

    @ManyToMany(mappedBy = "listOfMovies", fetch = FetchType.EAGER)
    public Set<Actor> getListOfActor() {
        return listOfActor;
    }

    public void setListOfActor(Set<Actor> listOfActor) {
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

    @ManyToOne(optional = false,targetEntity = Genre.class)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
