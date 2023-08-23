package com.mfcc.digi.data.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Result {

    private int id;
    private String name;
    private String description;
    private List<String> level;
    private List<String> attribute;
    private List<String> type;
    private List<String> nextEvolutions;
    private List<Field> fields;

    public static class ResultBuilder {

        @Override
        public String toString() {
            return "Digimon Information \n" +
                    "Code: " + id +
                    "\nName: " + name +
                    "\nDescription: " + description +
                    "\nLevel: " + level +
                    "\nAttribute: " + attribute +
                    "\nType: " + type +
                    "\nFields: " + fields +
                    "\nNextEvolutions: " + nextEvolutions;
        }
    }

    @Builder
    @Getter
    public static class Field {
        private String name;
        private String description;

        @Override
        public String toString() {
            return String.format("Name: %s Description: %s", name, description);
        }
    }

}
