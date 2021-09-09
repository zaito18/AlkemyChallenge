package com.example.challengev2.controller;
import com.example.challengev2.service.CharacterServiceImpl;
import com.example.challengev2.util.*;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CharacterController {

    private final CharacterServiceImpl actorServiceImpl;

    @Autowired
    public CharacterController(CharacterServiceImpl actorServiceImpl) {
        this.actorServiceImpl = actorServiceImpl;

    }

    @GetMapping("/characters")
    public ResponseEntity<List<CharacterDTO>> getAllActorsByFilter(@RequestParam MultiValueMap<String,String> params){
        return new ResponseEntity<>(actorServiceImpl.getAllCharactersDTO(params),HttpStatus.OK);
    }

    @GetMapping("/characters/details")
    public ResponseEntity<List<CharacterDTOII>> getAll() {
        return new ResponseEntity<>(actorServiceImpl.getAllCharacters(), HttpStatus.OK);
    }

    @PostMapping(value = "/characters/save")
    public ResponseEntity<?> save(@RequestBody CharacterDTOII characterDTOII) {
            actorServiceImpl.save(characterDTOII);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/characters/delete/{idCharacter}")
    public ResponseEntity<?> delete(@PathVariable (value = "idCharacter") Long idCharacter){
             actorServiceImpl.delete(idCharacter);
             return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/characters/update/{idCharacter}")
    public ResponseEntity<?> update(@PathVariable (value = "idCharacter") Long idCharacter,@RequestBody CharacterDTOII characterDetails){
            actorServiceImpl.update(idCharacter,characterDetails);
            return new ResponseEntity<>(HttpStatus.OK);
    }













}
