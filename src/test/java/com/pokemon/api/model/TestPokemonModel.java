package com.pokemon.api.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestPokemonModel {

	
	@InjectMocks
	PokemonEntity model;
	
	@Test
    void testBean() {
		
		
		
		model.setId(1l);
		model.setPokemonBreed("test");
		model.setPokemonDescription("test");
		model.setPokemonName("test");
	
	
		Assertions.assertEquals(1l, (long)model.getId());
		Assertions.assertEquals("test", model.getPokemonBreed());
		Assertions.assertEquals("test",model.getPokemonDescription());
		Assertions.assertEquals("test",model.getPokemonName());
		

	}
	

	@Test
	void testToString() {
		model.toString();
		Assertions.assertNotNull(model.toString());
	}

}
