package com.revature.pokeAPI.control;

import com.revature.pokeAPI.model.Pokemon;
import com.revature.pokeAPI.service.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PokeControl {

    @Autowired
    PokeService ps;


    @GetMapping("/all")
    public ResponseEntity getAllPokemon(){
        return ResponseEntity.ok( ps.getAllPokemon() );
    }

    @PutMapping
    public ResponseEntity upsertPokemon(@RequestBody Pokemon pokemon){
        return ResponseEntity.ok( ps.upsert(pokemon) );
    }

}
