package com.example.demo.controller;

import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/all")
    public List<Pokemon> findAll() {
        return pokemonService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pokemon pokemon) throws Exception {
        return pokemonService.save(pokemon);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws Exception {
        return pokemonService.findById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        return pokemonService.findByName(name);
    }

    @GetMapping("/type/{type}")
    public List<Pokemon> findAllByType(@PathVariable("type") String type) {
        return pokemonService.findAllByType(type);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
        return pokemonService.delete(id);
    }

    @PutMapping("/edit/{id}")
    public Pokemon edit(@PathVariable("id") Long id, @RequestBody Pokemon pokemon) throws Exception {
        return pokemonService.edit(id, pokemon);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAll() {
        return pokemonService.deleteAll();
    }
}
