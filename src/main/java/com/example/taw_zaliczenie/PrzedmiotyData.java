package com.example.taw_zaliczenie;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class PrzedmiotyData {

    //TWORZENIE LISTY PRZEDMIOTOW
    private List<Przedmiot> listaPrzedmiotow = new ArrayList<>();


    //dodawanie jednego przedmiotu
    public void dodajPrzedmiot(Przedmiot przedmiot)
    {
        listaPrzedmiotow.add(przedmiot);
    }

    //usuwanie jednego przedmiotu wg jego id
    public void usunPrzedmiotId(Integer id)
    {

        //usuwanie konkretnego przedmiotu
    }


    //usuwanie jednego przedmiotu wg jego nazwy
    public void usunPrzedmiotNazwa(String nazwa)
    {

        //usuwanie konkretnego przedmiotu
    }
    public void usunWszystkiePrzedmioty()
    {

        listaPrzedmiotow.clear();
    }
    public void generujPrzedmioty()
    {
        dodajPrzedmiot(new Przedmiot("Programowanie C++", 8, 211, true, "Programowanie struktoralne i objektowe w C++" ));
        dodajPrzedmiot(new Przedmiot("Programowanie Java", 10, 214, true, "Tworenie RestAPI w SpringBoot" ));
        dodajPrzedmiot(new Przedmiot("Modelowanie obiektowe", 3, 108, false, "Tworzenie modelu obiektowego aplikacji" ));
        dodajPrzedmiot(new Przedmiot("Inzynieria oprogramowania 1", 5, 108, true, "Metodologie wytwarzania oprogramowania" ));
        dodajPrzedmiot(new Przedmiot("Konstruowanie baz danych", 8, 211, false, "Podstawowe zasady konstruowania baz danych w MySQL" ));
        dodajPrzedmiot(new Przedmiot("Zaawansowane technologie bazodanowe", 10, 214, true, "Normalizacja, tranzakcje oraz funkcje i porcedury w MySQL" ));
        dodajPrzedmiot(new Przedmiot("Inzynieria oprogramowania 2", 5, 108, true, "Zaawansowane metodologie wytwarzania oprogramowania" ));
        dodajPrzedmiot(new Przedmiot("Zarzadzanie projektem informatycznym", 5, 108, true, "Harmonogramowanie, kontrola zasobow i sciezka krytyczna" ));

    }

    public List<Przedmiot> pobierzWszystkiePrzedmioty()
    {
        return listaPrzedmiotow;
    }

    public Przedmiot pobierzOstatniPrzedmiot()
    {
        return listaPrzedmiotow.get(listaPrzedmiotow.size() - 1);
    }


}
