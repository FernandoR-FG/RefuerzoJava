package com.mfcc.poke.data.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/*
* PokeDex
-------------------------------------------------------------------------------------------
1.- Name: blaziken
2.- Height: 1.9 m
3.- Weight: 52.0 kg
4.- Description: Puede saltar edificios de 30 plantas. Con sus golpes
de fuego quema a sus rivales.
5.- Type: fire fighting
6.- Weaknesses: ground rock water flying psychic fairy
7.- Base Point
            hp -> ********
            attack -> ************
            defense -> *******
            special-attack -> ***********
            special-defense -> *******
            speed -> ********
--------------------------------------------------------------------------------------------

* */
@Builder
@Getter
public class Pokemon {
    private String name;
    private int height;
    private int weight;
    private List<Types> types;
    private List<Stats> stats;
    private List<BasePoint> basePoints;

    @Builder
    @Getter
    public static class Types{
        private int slot;
        private PokemonType type;
    }
    @Builder
    @Getter
    public static class Stats{
        private String base_stat;
        private int effort;
        private PokemonStats stat;
    }


    @Builder
    @Getter
    public static class BasePoint {
        private int hp;
        private int attack;
        private String defense;
        private String specialAttack;
        private String specialDefense;
        private int speed;
    }

}

