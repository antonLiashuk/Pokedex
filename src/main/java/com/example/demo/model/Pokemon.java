package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String type;

    @Column
    private String name;

    public Pokemon() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon {" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /*dedicated for tests purpose*/
    public static Pokemon createPokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName("charizard");
        pokemon.setType("fire");
        pokemon.setId(1L);
        return pokemon;
    }
}
