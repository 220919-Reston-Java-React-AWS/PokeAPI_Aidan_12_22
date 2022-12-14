package com.revature.pokeAPI.service;

import com.revature.pokeAPI.dao.PokeRepo;
import com.revature.pokeAPI.exceptions.NotFoundException;
import com.revature.pokeAPI.model.Pokemon;
import com.revature.pokeAPI.model.Trainer;
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

    public Pokemon getPokemonById(int id){
        Optional<Pokemon> pokeOption = pr.findById(id);

        if (pokeOption.isEmpty()){
            throw new NotFoundException("Pokemon Not Found");
        }

        return pokeOption.get();
    }

    public Pokemon upsert(Pokemon pokemon){
        return pr.save(pokemon);
    }

    public void deletePokemonById(int id){
//
//        Pokemon pokemon = getPokemonById(id);
//        Trainer trainer = pokemon.getTrainer();
//        trainer.getPokemons().remove(pokemon);

        pr.deleteById(id);
    }

}
