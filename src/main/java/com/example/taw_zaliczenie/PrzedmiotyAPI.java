package com.example.taw_zaliczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PrzedmiotyAPI {

    @Autowired
    private PrzedmiotyData przedmiotyData;


    @GetMapping(value = "generuj")
    public String generujPrzedmioty()
    {
        return przedmiotyData.generujPrzedmioty();
    }

    @GetMapping(value = "przedmiot", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Przedmiot getPrzedmiot()
    {
        return przedmiotyData.pobierzOstatniPrzedmiot();
    }

    @GetMapping(value = "przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Przedmiot> getPrzedmioty()
    {
        return przedmiotyData.pobierzWszystkiePrzedmioty();
    }

    @PostMapping(value = "przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String dodajPrzedmiot(@RequestBody Przedmiot przedmiot)
    {
        przedmiotyData.dodajPrzedmiot(przedmiot);
        return "Udało się dodac przedmiot: "+przedmiot.getNazwa();
    }

    /* BODY w POST powinno wygladac np tak:
    {
        "nazwa": "Zarzadzanie projektem informatycznym",
        "ects": 5,
        "sala": 108,
        "egzamin": true,
        "opis": "Harmonogramowanie, kontrola zasobow i sciezka krytyczna"
    }
     */

    @DeleteMapping(value = "przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePrzedmioty()
    {
        przedmiotyData.usunWszystkiePrzedmioty();
    }


}
