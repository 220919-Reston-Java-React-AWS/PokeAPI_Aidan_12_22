package com.revature.pokeAPI.dao;

import com.revature.pokeAPI.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeRepo extends JpaRepository<Pokemon, Integer> {



}
