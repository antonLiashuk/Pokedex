package com.example.demo.service;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    public ResponseEntity<?> save(Pokemon pokemon) throws Exception {
        if (!pokemon.getName().isEmpty() || !pokemon.getType().isEmpty() || pokemon.getId() != null) {
            return new ResponseEntity<>(pokemonRepository.save(pokemon), HttpStatus.OK);
        }
        return new ResponseEntity<>("Type don't exists", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> findById(Long id) {
        if(id != null){
            return new ResponseEntity<>(pokemonRepository.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Long value of the id parameter can't be less than zero.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> findByName(String name) {
        if(!name.isEmpty()){
            return new ResponseEntity<>(pokemonRepository.findByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>("String value of the name neither can be null, nor length can be zero.", HttpStatus.BAD_REQUEST);
    }

    public List<Pokemon> findAllByType(String type) {
        if(!type.isEmpty()) {
            List<Pokemon> pokemons = pokemonRepository.findAllByType(type);
            return pokemons;
        }
        return null;
    }

    public ResponseEntity<?> delete(Long id) throws Exception {
        if(id != null) {
            Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(Exception::new);
            pokemonRepository.delete(pokemon);
            return new ResponseEntity<>("Pokemon that has been deleted: \n" + pokemon.toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("That pokemon doesn't exist in the database", HttpStatus.BAD_REQUEST);
    }

    public Pokemon edit(Long id, Pokemon pokemon) {
        if(id != null  || !pokemon.getName().isEmpty() || pokemon.getId() != null || !pokemon.getType().isEmpty()) {
            Optional<Pokemon> pokemonToChange = pokemonRepository.findById(Objects.requireNonNull(id));
            if(pokemonToChange.isPresent()) {
                pokemonToChange.get().setId(pokemon.getId());
                pokemonToChange.get().setName(pokemon.getName());
                pokemonToChange.get().setType(pokemon.getType());
                pokemonRepository.deleteById(id);
                return pokemonRepository.save(pokemonToChange.get());
            }
            return null;
        }
        return null;
    }

    public ResponseEntity<?> deleteAll() {
        pokemonRepository.deleteAll();
        return new ResponseEntity<>("All the elements of the database has been successfully deleted.", HttpStatus.OK);
    }
}