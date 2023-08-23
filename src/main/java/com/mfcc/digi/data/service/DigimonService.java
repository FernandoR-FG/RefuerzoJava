package com.mfcc.digi.data.service;

import com.mfcc.digi.data.model.Result;

import java.util.Optional;

public interface DigimonService {

    Optional<Result> getInfoDigimon(String name);
}
