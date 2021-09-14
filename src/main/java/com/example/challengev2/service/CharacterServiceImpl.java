package com.example.challengev2.service;

import com.example.challengev2.model.Character;

import com.example.challengev2.model.Movie;
import com.example.challengev2.repository.CharacterRepositoryImpl;
import com.example.challengev2.util.dto.CharacterDTO;
import com.example.challengev2.util.dto.CharacterDTOII;
import com.example.challengev2.util.dto.MovieDTO;
import com.example.challengev2.util.exception.IncompleteOrIncompatibleOrNullFieldsException;
import com.example.challengev2.util.exception.TheCharacterDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepositoryImpl characterRepositoryImpl;

    @Autowired
    public CharacterServiceImpl(CharacterRepositoryImpl characterRepositoryImpl){
        this.characterRepositoryImpl = characterRepositoryImpl;
    }

    @Override
    public List<CharacterDTO> getAllCharactersDTO(MultiValueMap<String,String> params) {
        List<Character> listToIterate =  characterRepositoryImpl.findAllByFilter(params);
        List<CharacterDTO> listToReturn=new ArrayList<>();
        for (Character aux:listToIterate){
            CharacterDTO characterDTO = new CharacterDTO(aux.getUrlImage(),aux.getName());
            listToReturn.add(characterDTO);
        }
        return listToReturn;
    }

    @Override
    public List<CharacterDTOII> getAllCharacters() {
        List<Character> listToIterate = characterRepositoryImpl.findAll();
        List<CharacterDTOII> listToReturn = new ArrayList<>();
        for (Character aux:listToIterate){
            List<MovieDTO> listOfMovies = iteration(aux.getListOfMovies());
            CharacterDTOII characterDTOII = new CharacterDTOII(aux.getUrlImage(),aux.getName(),aux.getAge(),aux.getWeight(),aux.getHistory());
            characterDTOII.setListOfMovies(listOfMovies);
            listToReturn.add(characterDTOII);
        }
        return listToReturn;
    }

    private List<MovieDTO> iteration(List<Movie> list){
        List<MovieDTO> listOfMovies = new ArrayList<>();
        for(Movie aux:list){
            MovieDTO movie = new MovieDTO(aux.getUrlImage(),aux.getTitle(),aux.getCreationDate(),aux.getRating());
            listOfMovies.add(movie);
        }
        return listOfMovies;
    }

    @Override
    public void save(CharacterDTOII characterDTOii) {

        if((characterDTOii.getName()==null || characterDTOii.getName().isBlank()) || characterDTOii.getAge()==null || (characterDTOii.getHistory()==null || characterDTOii.getHistory().isBlank()) || characterDTOii.getWeight()==null  || (characterDTOii.getUrlImage()==null || characterDTOii.getUrlImage().isBlank())){
            throw  new IncompleteOrIncompatibleOrNullFieldsException("Incomplete/incompatible or null fields");
        }
        else {
            Character character = new Character();
            character.setUrlImage(characterDTOii.getUrlImage());
            character.setName(characterDTOii.getName());
            character.setAge(characterDTOii.getAge());
            character.setHistory(characterDTOii.getHistory());
            character.setWeight(characterDTOii.getWeight());
            characterRepositoryImpl.save(character);
        }
    }

    @Override
    public void delete(Long id) {
        if(getCharacterById(id)==null){
            throw  new TheCharacterDoesNotExistException("The character does not exist");
        }
        characterRepositoryImpl.delete(getCharacterById(id));
    }

    @Override
    public Character getCharacterById(Long id) {
        return characterRepositoryImpl.getCharacterById(id);
    }

    @Override
    public void update(Long idCharacter, CharacterDTOII characterDetails) {
        Character character = characterRepositoryImpl.getCharacterById(idCharacter);
        if (character != null) {
            if ((characterDetails.getName() == null || characterDetails.getName().isBlank()) || characterDetails.getAge() == null || (characterDetails.getHistory() == null || characterDetails.getHistory().isBlank()) || characterDetails.getWeight() == null || (characterDetails.getUrlImage() == null || characterDetails.getUrlImage().isBlank())) {
                throw new IncompleteOrIncompatibleOrNullFieldsException("Incomplete/incompatible or null fields");
            }
            character.setUrlImage(characterDetails.getUrlImage());
            character.setName(characterDetails.getName());
            character.setAge(characterDetails.getAge());
            character.setWeight(characterDetails.getWeight());
            character.setHistory(characterDetails.getHistory());
            characterRepositoryImpl.save(character);
        } else {
            throw new TheCharacterDoesNotExistException("The character does not exist");
        }
    }



}

