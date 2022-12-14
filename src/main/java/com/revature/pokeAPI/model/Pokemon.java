package com.revature.pokeAPI.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier for each post

    private int numId; // The id of the pokemon itself (i.e. Bulbasaur is 1, Venusaur 2, etc.)

    private String pokename;

    private int pokelevel;

    private String imageUrl;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinTable(name="trainer_pokemons",
            joinColumns = @JoinColumn(
                    name = "pokemons_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "trainer_id",
                    referencedColumnName = "id"
            )
    )
    @JsonBackReference
    private Trainer trainer;


}
