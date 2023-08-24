package com.mfcc.poke.data;

import com.mfcc.poke.data.client.PokemonClientApi;
import com.mfcc.poke.data.client.PokemonTypeClientApi;
import com.mfcc.poke.data.controllers.GenerateDataPokemon;
import com.mfcc.poke.data.model.Pokemon;
import com.mfcc.poke.data.model.PokemonWeakness;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class PokemonApplication {


    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(PokemonClientApi pokemonClientApi, PokemonTypeClientApi pokemonTypeClientApi) {
        return args -> {
            Pokemon pokemonInfo = pokemonClientApi.getDataPokemon("blaziken");
            GenerateDataPokemon data = new GenerateDataPokemon(pokemonInfo, pokemonClientApi);
            data.getInformationPokemon();

           // Pokemon pokemonWeakness = pokemonTypeClientApi.getDataTypePokemon("2");
           // GenerateDataPokemon data2 = new GenerateDataPokemon(pokemonWeakness,pokemonTypeClientApi);

        };
    }
    /*
    public CommandLineRunner run(DigimonClientApi digimonClientApi) {
        return args -> {
            Digimon digimonInfo = digimonClientApi.getDigimonInfo("Garummon");
            GenerateData data = new GenerateData(digimonInfo, digimonClientApi);
            data.getInformation();

        };
    }
    */
}
