package com.mfcc.digi.data.model;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Builder
@Getter
public class DigimonField {

    private int id;
    private String name;
    private String description;

}
