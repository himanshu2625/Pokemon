package com.pokemon.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.api.model.PokemonEntity;
import com.pokemon.api.repository.PokemonRepository;
import com.pokemon.api.service.PokemonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Pokemoncontroller {

	
	private final PokemonService service;
	
	@GetMapping("/getAllPokemon")
	public List<PokemonEntity> getPokemon() {
		
		return service.getPokemon();
	}
	
	@GetMapping("/getPokemonById/{id}")
	public Optional<PokemonEntity> getPokemonById(@PathVariable long id) {
		
		
		
		return service.getPokemonById(id);
	}
	@PostMapping("/addPokemon")
	public PokemonEntity addPokemon(@RequestBody PokemonEntity pokemon) {
		
		return service.addPokemon(pokemon);
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		
		 return service.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PokemonEntity> update(@PathVariable long id ,@RequestBody PokemonEntity pokemon) {
	
		 return service.update(id, pokemon);
		
	}
}
