package com.mfcc.poke.data.client;

import com.mfcc.poke.data.model.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="pokemonTypeApi", url = "https://pokeapi.co/api/v2/type/")
public interface PokemonTypeClientApi {
    @GetMapping("/{name}")
    Pokemon getDataTypePokemon(@PathVariable String name);
}
