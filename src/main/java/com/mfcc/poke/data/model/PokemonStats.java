package com.mfcc.poke.data.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PokemonStats {
    private String name;
    private String url;

    public PokemonStats() {

    }

    public PokemonStats(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
