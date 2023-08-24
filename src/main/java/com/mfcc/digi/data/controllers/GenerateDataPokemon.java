package com.mfcc.digi.data.controllers;

import com.mfcc.digi.data.client.PokemonClientApi;
import com.mfcc.digi.data.model.Pokemon;
import com.mfcc.digi.data.model.PokemonType;
import com.mfcc.digi.data.model.ResultPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenerateDataPokemon {

    private Pokemon pokemon;
    private PokemonClientApi pokemonClientApi;

    /*
       public GenerateDataPokemon(Pokemon pokemon, PokemonClientApi pokemonClientApi,
                               PokemonSpeciesClientApi pokemonSpeciesClientApi,
                               pokemonTypeClientApi pokemonTypeClientApi){
        this.pokemon = pokemon;
        this.pokemonClientApi = pokemonClientApi;
        this.pokemonSpeciesClientApi = pokemonSpeciesClientApi;
        this.pokemonTypeClientApi = pokemonTypeClientApi;
    }
    * */
    public GenerateDataPokemon(Pokemon pokemon, PokemonClientApi pokemonClientApi){
        this.pokemon = pokemon;
        this.pokemonClientApi = pokemonClientApi;
    }

    public Optional<ResultPokemon> getInformationPokemon(){
        if(pokemon != null){
            ResultPokemon.ResultPokemonBuilder resultPokemonBuilder = ResultPokemon.builder();
            resultPokemonBuilder.name(pokemon.getName());
            resultPokemonBuilder.height(pokemon.getHeight());
            resultPokemonBuilder.weight(pokemon.getWeight());



            List<String> typeNames = new ArrayList<>();

            for (Pokemon.Types typeInfo : pokemon.getTypes()) {

                PokemonType typesList = typeInfo.getTypesList();
                if(typesList!=null) {
                    typeNames.add(typesList.getName());
                }
            }

            resultPokemonBuilder.type(typeNames);




            System.out.println(resultPokemonBuilder);
            return Optional.of(resultPokemonBuilder.build());

        }
        return Optional.empty();
    }
}
