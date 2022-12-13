package com.revature.pokeAPI.dao;

import com.revature.pokeAPI.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer, Integer> {



}
