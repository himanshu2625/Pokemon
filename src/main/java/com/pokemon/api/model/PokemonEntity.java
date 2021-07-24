package com.pokemon.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name ="pokemontable")
@Data
public class PokemonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String pokemonName;
	private String pokemonBreed;
	private String pokemonDescription;
	
	}
