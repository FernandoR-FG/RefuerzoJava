package com.mfcc.digi.data.service.impl;

import com.mfcc.digi.data.client.DigimonClientApi;
import com.mfcc.digi.data.controllers.GenerateData;
import com.mfcc.digi.data.model.Digimon;
import com.mfcc.digi.data.model.Result;
import com.mfcc.digi.data.service.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DigimonServiceImpl implements DigimonService {

    @Autowired
    private DigimonClientApi digimonClientApi;

    @Override
    public Optional<Result> getInfoDigimon(String name) {
        Digimon digimonInfo = digimonClientApi.getDigimonInfo(name);
        GenerateData generateData = new GenerateData(digimonInfo, digimonClientApi);
        return generateData.getInformation();
    }
}
