package com.revature.pokeAPI.service;

import com.revature.pokeAPI.dao.PokeRepo;
import com.revature.pokeAPI.dao.TrainerRepo;
import com.revature.pokeAPI.exceptions.NotFoundException;
import com.revature.pokeAPI.model.Pokemon;
import com.revature.pokeAPI.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainerService {

    @Autowired
    TrainerRepo tr;

    @Autowired
    PokeService ps;

    public Trainer getTrainer(int id){
        Optional<Trainer> trainerOption = tr.findById(id);

        if (trainerOption.isEmpty()){
            throw new NotFoundException("Trainer Not Found");
        }

        return trainerOption.get();
    }

    public Trainer upsertTrainer(Trainer trainer){
        return tr.save(trainer);
    }

    public Trainer addPokemonToParty(int trainerId, Pokemon pokemon){
        Trainer trainer = getTrainer(trainerId);

//        pokemon.setTrainer(trainer);
//        pokemon = ps.upsert(pokemon);

        List<Pokemon> party = trainer.getPokemons();
        party.add(pokemon);

        return upsertTrainer(trainer);
    }

}
