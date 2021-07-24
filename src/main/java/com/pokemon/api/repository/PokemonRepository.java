package com.pokemon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.api.model.PokemonEntity;

import lombok.RequiredArgsConstructor;

@Repository

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long>{

}
