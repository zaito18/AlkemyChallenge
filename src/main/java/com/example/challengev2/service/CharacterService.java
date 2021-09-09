package com.example.challengev2.service;

import com.example.challengev2.model.Character;
import com.example.challengev2.util.CharacterDTO;
import com.example.challengev2.util.CharacterDTOII;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> getAllCharactersDTO(MultiValueMap<String,String> params);

    List <CharacterDTOII> getAllCharacters();

    void save(CharacterDTOII character);

    void delete(Long id);

    Character getCharacterById(Long id);

    void update(Long idCharacter, CharacterDTOII characterDetails);
}
