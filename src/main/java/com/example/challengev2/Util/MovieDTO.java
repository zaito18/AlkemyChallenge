package com.example.challengev2.Util;

import java.util.Calendar;

public class MovieDTO {

    private String urlImage;
    private String title;
    private Calendar creationDate;
    private String rating;

    public MovieDTO(String urlImage, String title, Calendar creationDate, String rating) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
