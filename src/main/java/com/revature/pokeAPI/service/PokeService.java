package com.revature.pokeAPI.service;

import com.revature.pokeAPI.dao.PokeRepo;
import com.revature.pokeAPI.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokeService {

    @Autowired
    PokeRepo pr;


    public List<Pokemon> getAllPokemon(){
        return pr.findAll();
    }

    public Pokemon upsert(Pokemon pokemon){
        return pr.save(pokemon);
    }

}
