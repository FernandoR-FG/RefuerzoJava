package com.mfcc.digi.data.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Digimon {

    private int id;
    private String name;
    private List<Levels> levels;
    private List<Descriptions> descriptions;
    private List<Types> types;
    private List<Attributes> attributes;
    private List<Fields> fields;
    private List<NextEvolutions> nextEvolutions;

    @Builder
    @Getter
    public static class Levels {
        private int id;
        private String level;
    }

    @Builder
    @Getter
    public static class Descriptions {
        private String language;
        private String description;
    }

    @Builder
    @Getter
    public static class Types {
        private int id;
        private String type;
    }

    @Builder
    @Getter
    public static class Attributes {
        private int id;
        private String attribute;
    }

    @Builder
    @Getter
    public static class Fields {
        private int id;
        private String field;
        private String image;
    }

    @Builder
    @Getter
    public static class NextEvolutions {
        private int id;
        private String digimon;
        private String condition;
        private String url;
    }



}
