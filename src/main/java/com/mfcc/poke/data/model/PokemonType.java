package com.mfcc.poke.data.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PokemonType {
    private String name;
    private String url;

    public PokemonType(){

    }
    public PokemonType(String name, String url) {
        this.name = name;
        this.url = url;
    }
}


