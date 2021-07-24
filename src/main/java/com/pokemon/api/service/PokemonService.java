package com.pokemon.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.api.model.PokemonEntity;
import com.pokemon.api.repository.PokemonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PokemonService {
	
	private final PokemonRepository repository;
	
	public List<PokemonEntity> getPokemon() {
		
		return repository.findAll();
	}
	
	
	public Optional<PokemonEntity> getPokemonById(long id) {
		
		Optional<PokemonEntity> pokemon = repository.findById(id);
		
		return pokemon;
	}
	
	public PokemonEntity addPokemon(PokemonEntity pokemon) {
		
		return repository.save(pokemon);
		
	}

	public String delete(long id)
	{
		repository.deleteById(id);
		 return "Pokemon Delete Successfully";
	}
	
	
	public ResponseEntity<PokemonEntity> update(long id , PokemonEntity p) {
	    Optional<PokemonEntity> pokemon =repository.findById(id);
		 PokemonEntity newPokemon = new PokemonEntity();
		 newPokemon.setId(p.getId());
		 newPokemon.setPokemonName(p.getPokemonName());
		 newPokemon.setPokemonBreed(p.getPokemonBreed());
		 newPokemon.setPokemonDescription(p.getPokemonDescription());
		  repository.save(newPokemon);
		 return new ResponseEntity<PokemonEntity>(p, HttpStatus.OK);
		
	}
	
}
