package com.mfcc.digi.data.controllers;

import com.mfcc.digi.data.model.Result;
import com.mfcc.digi.data.service.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DigimonController {

    @Autowired
    private DigimonService digimonService;

    @GetMapping("/course/digimon/{name}")
    public ResponseEntity<?> getDigimonInfo(@PathVariable String name) {
        Optional<Result> optionalResult = digimonService.getInfoDigimon(name);
        if (optionalResult.isPresent()) {
            return ResponseEntity.ok(optionalResult.get());
        }
        return ResponseEntity.notFound().build();
    }

}
