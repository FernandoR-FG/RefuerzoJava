package com.mfcc.poke.data.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ResultPokemon {
    private String name;
    private int height;
    private int weight;
    private List<String> type;
    private List<String> stats;
    private List<String> double_damage_from;
    public static class ResultPokemonBuilder{
        @Override
        public String toString() {
            return "--------------POKEDEX--------------" +
                    "\nName:'" + name +
                    "\nHeight: " + height + " m" +
                    "\nWeight: " + weight + " kg" +
                    "\nType: " + type +
                    "\nWeaknesses: " + double_damage_from+
                    "\nBase Point: " + ' '+
                    "\n\t\tHp: " + stats.get(0)+
                    "\n\t\tAttack: " +  stats.get(1)+
                    "\n\t\tDefense: " + stats.get(2)+
                    "\n\t\tSpecial attack: " + stats.get(3)+
                    "\n\t\tSpecial defense: " + stats.get(4)+
                    "\n\t\tspeed: " + stats.get(5);

        }
    }
}
