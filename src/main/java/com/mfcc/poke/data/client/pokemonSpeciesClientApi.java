package com.mfcc.poke.data.client;

import com.mfcc.poke.data.model.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="pokemonSpeciesApi", url = "https://pokeapi.co/api/v2/pokemon-species/")
public interface pokemonSpeciesClientApi {
    @GetMapping("/{name}")
    Pokemon getDataSpeciesPokemon(@PathVariable String name);
}
