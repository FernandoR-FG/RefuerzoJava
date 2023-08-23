package com.mfcc.digi.data.controllers;

import com.mfcc.digi.data.client.DigimonClientApi;
import com.mfcc.digi.data.model.Digimon;
import com.mfcc.digi.data.model.DigimonField;
import com.mfcc.digi.data.model.Result;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class GenerateData {

    private Digimon digimon;
    private DigimonClientApi digimonClientApi;

    public GenerateData(Digimon digimon, DigimonClientApi digimonClientApi) {
        this.digimon = digimon;
        this.digimonClientApi = digimonClientApi;
    }

    public Optional<Result> getInformation() {
        if (digimon != null) {
            Result.ResultBuilder resultBuilder = Result.builder();
            resultBuilder.id(digimon.getId());
            resultBuilder.name(digimon.getName());
            String description = digimon.getDescriptions().stream()
                    .filter(descriptions -> "en_us".equals(descriptions.getLanguage()))
                    .findFirst().orElse(Digimon.Descriptions.builder().description("Description not found").build())
                    .getDescription();
            resultBuilder.description(description);
            List<String> levels = digimon.getLevels().stream()
                    .map(Digimon.Levels::getLevel).collect(Collectors.toList());
            resultBuilder.level(levels);
            List<String> attributes = digimon.getAttributes().stream()
                    .map(Digimon.Attributes::getAttribute).collect(Collectors.toList());
            resultBuilder.attribute(attributes);
            List<String> types = digimon.getTypes().stream()
                    .map(Digimon.Types::getType).collect(Collectors.toList());
            resultBuilder.type(types);
            List<String> nextEvolutions = digimon.getNextEvolutions().stream()
                    .filter(nextEvolution -> !nextEvolution.getCondition().isEmpty())
                    .map(Digimon.NextEvolutions::getDigimon).collect(Collectors.toList());
            resultBuilder.nextEvolutions(nextEvolutions);

            List<Result.Field> fields = new ArrayList<>();
            digimon.getFields().forEach(field -> {
                DigimonField digimonField = digimonClientApi.getDigimonField(field.getField());
                fields.add(Result.Field.builder().name(digimonField.getName())
                        .description(digimonField.getDescription())
                        .build());
            });
            resultBuilder.fields(fields);
            log.info(resultBuilder.toString());
            return Optional.of(resultBuilder.build());
        }
        return Optional.empty();
    }

}
