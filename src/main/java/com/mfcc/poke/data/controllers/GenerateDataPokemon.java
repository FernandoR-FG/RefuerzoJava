package com.mfcc.poke.data.controllers;

import com.mfcc.poke.data.client.PokemonClientApi;
import com.mfcc.poke.data.client.PokemonTypeClientApi;
import com.mfcc.poke.data.model.Pokemon;
import com.mfcc.poke.data.model.PokemonStats;
import com.mfcc.poke.data.model.PokemonType;
import com.mfcc.poke.data.model.ResultPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenerateDataPokemon {

    private Pokemon pokemon;
    private PokemonClientApi pokemonClientApi;
    private PokemonTypeClientApi pokemonTypeClientApi;

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

    public GenerateDataPokemon(Pokemon pokemon, PokemonTypeClientApi pokemonTypeClientApi){
        this.pokemon = pokemon;
        this.pokemonTypeClientApi = pokemonTypeClientApi;
    }

    public Optional<ResultPokemon> getInformationPokemon(){
        if(pokemon != null){
            ResultPokemon.ResultPokemonBuilder resultPokemonBuilder = ResultPokemon.builder();
            resultPokemonBuilder.name(pokemon.getName());
            resultPokemonBuilder.height(pokemon.getHeight());
            resultPokemonBuilder.weight(pokemon.getWeight());



            List<String> typeNames = new ArrayList<>();

            for (Pokemon.Types typeInfo : pokemon.getTypes()) {

                PokemonType typesList = typeInfo.getType();
                if(typesList!=null) {
                    typeNames.add(typesList.getName());
                }
            }

            resultPokemonBuilder.type(typeNames);

            List<String> basePoint = new ArrayList<>();
            for(Pokemon.Stats statsInfo : pokemon.getStats()){
                    basePoint.add(statsInfo.getBase_stat());
                }


            resultPokemonBuilder.stats(basePoint);

            System.out.println(resultPokemonBuilder);
            return Optional.of(resultPokemonBuilder.build());

        }
        return Optional.empty();
    }
}
