package com.mfcc.poke.data.controllers;

import com.mfcc.poke.data.client.PokemonClientApi;
import com.mfcc.poke.data.client.PokemonTypeClientApi;
import com.mfcc.poke.data.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenerateDataPokemon {

    private Pokemon pokemon;
    private PokemonWeakness pokemonWeakness;
    private PokemonClientApi pokemonClientApi;
    private PokemonTypeClientApi pokemonTypeClientApi;


    public GenerateDataPokemon(Pokemon pokemon, PokemonClientApi pokemonClientApi){
        this.pokemon = pokemon;
        this.pokemonClientApi = pokemonClientApi;
    }

    public GenerateDataPokemon(PokemonWeakness pokemonWeakness, PokemonTypeClientApi pokemonTypeClientApi){
        this.pokemonWeakness = pokemonWeakness;
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




            List<String> weaknessPokemon = new ArrayList<>();

            if (pokemonWeakness != null && pokemonWeakness.getDouble_damage_from() != null) {
                for (PokemonWeakness.Double_damage_from weaknessName : pokemonWeakness.getDouble_damage_from()) {
                    String weakList = weaknessName.getName();

                    if (weakList != null) {
                        weaknessPokemon.add(weakList);
                    }
                }
            }
                resultPokemonBuilder.double_damage_from(weaknessPokemon);
/*
            List<String> weaknessPokemon = new ArrayList<>();
            for (PokemonWeakness.Double_damage_from weaknessName : pokemonWeakness.getDouble_damage_from()) {
                String weakList = weaknessName.getName();

                if (weakList != null) {
                    weaknessPokemon.add(weakList);
                }
            }

            resultPokemonBuilder.double_damage_from(weaknessPokemon);
            */




            System.out.println(resultPokemonBuilder);
            return Optional.of(resultPokemonBuilder.build());

        }
        return Optional.empty();
    }
}
