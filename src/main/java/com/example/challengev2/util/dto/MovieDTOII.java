package com.example.challengev2.util.dto;

import java.util.Calendar;

public class MovieDTOII {
    private String urlImage;
    private String title;
    private Calendar creationDate;


    public MovieDTOII(String urlImage, String title, Calendar creationDate) {
        this.urlImage = urlImage;
        this.title = title;
        this.creationDate=creationDate;
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

}
