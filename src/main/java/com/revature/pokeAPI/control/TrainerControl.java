package com.revature.pokeAPI.control;

import com.revature.pokeAPI.model.Pokemon;
import com.revature.pokeAPI.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
@CrossOrigin(origins = {"http://localhost:3000"})
public class TrainerControl {

    @Autowired
    TrainerService ts;

    @GetMapping(path="/{id}")
    public ResponseEntity getById(@PathVariable int id){
        return ResponseEntity.ok( ts.getTrainer(id) );
    }

    @PutMapping(path="/{id}")
    public ResponseEntity addPokemon(@PathVariable int id, @RequestBody Pokemon pokemon){
        return ResponseEntity.ok( ts.addPokemonToParty(id, pokemon) );
    }
}
