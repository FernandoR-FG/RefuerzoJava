package com.mfcc.digi.data.client;

import com.mfcc.digi.data.model.Digimon;
import com.mfcc.digi.data.model.DigimonField;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "digimonApi", url="https://digimon-api.com/api/v1")
public interface DigimonClientApi {

    @GetMapping("/digimon/{digimon}")
    Digimon getDigimonInfo(@PathVariable String digimon);

    @GetMapping("/field/{name}")
    DigimonField getDigimonField(@PathVariable String name);

}
