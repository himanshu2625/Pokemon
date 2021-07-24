package com.pokemon.api.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pokemon.api.model.PokemonEntity;
import com.pokemon.api.service.PokemonService;

@ExtendWith(MockitoExtension.class)
public class TestPokemonController {

	@InjectMocks
	Pokemoncontroller pokemoncontroller;
	
	@Mock
	PokemonService service;
	
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
		List<PokemonEntity> pokemon =pokemoncontroller.getPokemon();
		Assertions.assertNotNull(pokemon);
	}
	@Test
	void testAddPokemon() {
		
		Mockito.when(service.addPokemon(Mockito.any())).thenReturn(pokimon);
		PokemonEntity response =pokemoncontroller.addPokemon(pokimon);
		Assertions.assertNotNull(response);
		Assertions.assertEquals("test", response.getPokemonName());
	}
	@Test
	void testGetByIdPokemon() {
		Optional<PokemonEntity> res =Optional.of(pokimon);
		Mockito.when(service.getPokemonById(Mockito.anyLong())).thenReturn(res);
		Optional<PokemonEntity> response =pokemoncontroller.getPokemonById(1);
		Assertions.assertNotNull(response);
	}
	@Test
	void testDeletePokemon() {
		String str ="Pokimon delete Successfully";
		Mockito.when(service.delete(Mockito.anyLong())).thenReturn(str);
		String response =pokemoncontroller.delete(1);
		Assertions.assertNotNull(response);
	}
	
	@Test
	void testUpdatePokemon() {
		ResponseEntity<PokemonEntity> res = new ResponseEntity<>(pokimon,HttpStatus.OK);
		Mockito.when(service.update(Mockito.anyLong(), Mockito.any())).thenReturn(res);
		ResponseEntity<PokemonEntity> response =pokemoncontroller.update(1,pokimon);
		Assertions.assertNotNull(response);
	}

}
