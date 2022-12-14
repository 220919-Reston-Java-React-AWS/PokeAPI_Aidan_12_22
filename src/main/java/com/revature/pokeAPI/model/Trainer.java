package com.revature.pokeAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier for each post

    private String name;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinTable(name="trainer_pokemons",
            joinColumns = @JoinColumn(
                    name = "trainer_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "pokemons_id",
                    referencedColumnName = "id"
            )
    )
    private List<Pokemon> pokemons;

}
