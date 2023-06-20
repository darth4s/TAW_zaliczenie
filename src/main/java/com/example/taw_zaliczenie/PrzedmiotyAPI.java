package com.example.taw_zaliczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PrzedmiotyAPI {

    @Autowired
    private PrzedmiotyData przedmiotyData;

    @GetMapping(value = "generuj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void generujPrzedmioty()
    {
        przedmiotyData.generujPrzedmioty();
    }

}
