package com.example.challengev2.service;

import com.example.challengev2.model.Character;
import com.example.challengev2.repository.CharacterRepository;
import com.example.challengev2.repository.CharacterRepositoryImpl;
import com.example.challengev2.util.dto.CharacterDTOII;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterServiceImplTest {

    private CharacterService characterService;
    private CharacterRepository characterRepository;

    @BeforeEach
    public void  init(){
        characterRepository = mock(CharacterRepositoryImpl.class);
        characterService = new CharacterServiceImpl((CharacterRepositoryImpl) characterRepository);
    }

    @Test
    void getAllCharactersDTO() {
        //given
        List<Character> list = new ArrayList<>();
        Character character = new Character();
        character.setAge(30);
        character.setHistory("Titanic");
        character.setName("Di caprio");
        character.setWeight(78.6D);
        character.setUrlImage("path");
        list.add(character);
        //when
        when(characterRepository.findAll()).thenReturn(list);
        // then
        Assertions.assertEquals(characterService.getAllCharacters().size(),list.size());
    }

    @Test
    void getAllCharacters() {
    }

    @Test
    void save() {
        //given
        Character character = new Character();
        character.setIdCharacter(1L);
        character.setAge(30);
        character.setHistory("Titanic");
        character.setName("Di caprio");
        character.setWeight(78.6D);
        character.setUrlImage("path");
        CharacterDTOII characterDTO = new CharacterDTOII();
        characterDTO.setAge(30);
        characterDTO.setHistory("Titanic");
        characterDTO.setName("Di caprio");
        characterDTO.setWeight(78.6D);
        characterDTO.setUrlImage("path");
        characterService.save(characterDTO);
        verify(characterRepository,times(1)).save(character);
    }
    @Test
    void delete() {



    }

    @Test
    void getCharacterById() {
    }

    @Test
    void update() {
    }
}