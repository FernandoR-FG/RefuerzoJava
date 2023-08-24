package com.mfcc.poke.data.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PokemonType {
    private String name;
    private String url;
}
