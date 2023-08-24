package com.mfcc.poke.data.client;
import com.mfcc.poke.data.model.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="pokemonApi", url = "https://pokeapi.co/api/v2/pokemon")
public interface PokemonClientApi {
@GetMapping("/{endpoint}")
Pokemon getDataPokemon(@PathVariable String endpoint);

}
