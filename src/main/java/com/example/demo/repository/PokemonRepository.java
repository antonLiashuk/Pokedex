package com.example.demo.repository;

import com.example.demo.model.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByName(String name);
    List<Pokemon> findAllByType(String type);
}