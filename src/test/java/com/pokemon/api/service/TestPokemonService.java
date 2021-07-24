package com.pokemon.api.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import com.pokemon.api.model.PokemonEntity;
import com.pokemon.api.repository.PokemonRepository;


@ExtendWith(MockitoExtension.class)
public class TestPokemonService {

	@InjectMocks
	PokemonService pokemonService;
	
	@Mock
	PokemonRepository repository;
	
	PokemonEntity pokimon;
	@BeforeEach
	void setUp() {
	    pokimon = new PokemonEntity();
		pokimon.setId(1);
		pokimon.setPokemonBreed("test");;
		pokimon.setPokemonDescription("test");
		pokimon.setPokemonName("test");
	}
	
	@Test
	void testGetPokemon() {
		List<PokemonEntity> pokemon =pokemonService.getPokemon();
		Assertions.assertNotNull(pokemon);
	}
	@Test
	void testAddPokemon() {
		
		Mockito.when(repository.save(Mockito.any())).thenReturn(pokimon);
		PokemonEntity response =pokemonService.addPokemon(pokimon);
		Assertions.assertNotNull(response);
		Assertions.assertEquals("test", response.getPokemonName());
	}
	@Test
	void testGetByIdPokemon() {
		Optional<PokemonEntity> res =Optional.of(pokimon);
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(res);
		Optional<PokemonEntity> response =pokemonService.getPokemonById(1);
		Assertions.assertNotNull(response);
	}
	@Test
	void testDeletePokemon() {
		
		
		String response =pokemonService.delete(1);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void testUpdatePokemon() {
		
		ResponseEntity<PokemonEntity> response =pokemonService.update(1,pokimon);
		Assertions.assertNotNull(response);
	}

}
