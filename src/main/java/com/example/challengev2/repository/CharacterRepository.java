package com.example.challengev2.repository;

import com.example.challengev2.model.Character;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface CharacterRepository {

    List<Character> findAllByFilter(MultiValueMap<String,String> params);
    void save(Character character);
    void delete(Character character);
    List<Character> findAll();
    Character getCharacterById(Long idActor);
}
