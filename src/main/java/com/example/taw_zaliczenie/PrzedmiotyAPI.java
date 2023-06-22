package com.example.taw_zaliczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
        przedmiotyData.generujPrzedmioty();
        return "Dodano nowe przedmioty do listy przedmiotow!";
    }

    @GetMapping(value = "przedmiot", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Przedmiot getPrzedmiot()
    {
        return przedmiotyData.pobierzOstatniPrzedmiot();
    }

    @GetMapping(value = "przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Przedmiot>> getPrzedmioty(@Nullable @RequestParam("id") Integer id,
                                         @Nullable @RequestParam("sala") Integer sala,
                                         @Nullable @RequestParam("egzamin") Boolean egzamin
    )
    {

        if (przedmiotyData.pobierzPrzedmioty(id, sala, egzamin).isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(przedmiotyData.pobierzPrzedmioty(id, sala, egzamin));
        }

        //return przedmiotyData.pobierzPrzedmioty(id, sala, egzamin);  -- stara wersja

    }

    @GetMapping (value = "przedmiot/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPrzedmiotId(@PathVariable("id") Integer id)
    {
        Przedmiot przedmiot = przedmiotyData.pobierzPrzedmiotId(id);
        if (przedmiot==null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(przedmiot);
        }

    }

    @PostMapping(value = "przedmioty", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String dodajPrzedmiot(@RequestBody Przedmiot przedmiot)
    {
        przedmiotyData.dodajPrzedmiot(przedmiot);
        return "Udalo sie dodac przedmiot: "+przedmiot.getNazwa();
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
    public String deletePrzedmioty()
    {
        przedmiotyData.usunWszystkiePrzedmioty();
        return "Lista przedmiotow wyczyszczona!";
    }

    @DeleteMapping (value = "przedmiot/{id}")
    public ResponseEntity deletePrzedmiotId(@PathVariable("id") Integer id)
    {
        boolean usuniety = przedmiotyData.usunPrzedmiotId(id);
        if (usuniety == true)
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }



}
