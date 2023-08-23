package com.mfcc.digi.data;

import com.mfcc.digi.data.client.DigimonClientApi;
import com.mfcc.digi.data.controllers.GenerateData;
import com.mfcc.digi.data.model.Digimon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DigimonApplication {


    public static void main(String[] args) {
        SpringApplication.run(DigimonApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(DigimonClientApi digimonClientApi) {
        return args -> {
            Digimon digimonInfo = digimonClientApi.getDigimonInfo("Garummon");
            GenerateData data = new GenerateData(digimonInfo, digimonClientApi);
            data.getInformation();

        };
    }

}
