package com.example.challengev2.util.dto;

import java.util.List;

public class CharacterDTOII {

    private String urlImage;
    private String name;
    private Integer age;
    private Double weight;
    private String history;

    public CharacterDTOII() {
    }

    public List<MovieDTO> getListOfMovies() {
        return listOfMovies;
    }

    public void setListOfMovies(List<MovieDTO> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    private List<MovieDTO> listOfMovies;

    public CharacterDTOII(String urlImage, String name, Integer age, Double weight, String history) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

}