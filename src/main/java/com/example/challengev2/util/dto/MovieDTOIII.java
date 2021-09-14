package com.example.challengev2.util.dto;

import com.example.challengev2.util.dto.CharacterDTOII;

import java.util.Calendar;
import java.util.List;

public class MovieDTOIII {

    private String urlImage;
    private String title;
    private Calendar creationDate;
    private Integer rating;
    private List<CharacterDTOII> listOfActor;

    public MovieDTOIII(String urlImage, String title, Calendar creationDate, Integer rating) {
        this.urlImage = urlImage;
        this.title = title;
        this.creationDate = creationDate;
        this.rating = rating;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<CharacterDTOII> getListOfActor() {
        return listOfActor;
    }

    public void setListOfActor(List<CharacterDTOII> listOfActor) {
        this.listOfActor = listOfActor;
    }
}
