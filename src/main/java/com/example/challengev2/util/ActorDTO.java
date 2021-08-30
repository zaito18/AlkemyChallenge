package com.example.challengev2.util;

public class ActorDTO {

    private String urlImage;
    private String name;

    public ActorDTO(String urlImage, String name) {
        this.urlImage = urlImage;
        this.name = name;
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
}
