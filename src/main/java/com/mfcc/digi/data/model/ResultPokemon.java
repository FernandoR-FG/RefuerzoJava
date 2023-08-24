package com.mfcc.digi.data.model;

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
    public static class ResultPokemonBuilder{
        @Override
        public String toString() {
            return "--------------POKEDEX--------------" +
                    "\nName:'" + name +
                    "\nHeight: " + height + " m" +
                    "\nWeight: " + weight + " kg" +
                    "\nType: " + type +
                    "\nWeaknesses: " + "--------"+
                    "\nBase Point: " + ' '+
                    "\n\t\thp: " + "--------"+
                    "\n\t\tattack: " + "--------"+
                    "\n\t\tspecial-defense: " + "--------"+
                    "\n\t\tspeed: " + "--------";

        }
    }
}
