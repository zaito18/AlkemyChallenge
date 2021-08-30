package com.example.challengev2.util;

import java.util.List;

public class ActorDTOII {

    private String urlImage;
    private String name;
    private String age;
    private String weight;
    private String history;

    public List<MovieDTO> getListOfMovies() {
        return listOfMovies;
    }

    public void setListOfMovies(List<MovieDTO> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    private List<MovieDTO> listOfMovies;

    public ActorDTOII(String urlImage, String name, String age, String weight, String history) {
        this.urlImage = urlImage;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
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