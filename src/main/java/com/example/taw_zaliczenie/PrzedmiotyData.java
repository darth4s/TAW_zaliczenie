package com.example.taw_zaliczenie;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void usunWszystkiePrzedmioty()
    {

        listaPrzedmiotow.clear();
    }

    public boolean usunPrzedmiotId(Integer id)
    {
        Przedmiot doUsuniecia = null;
        for (Przedmiot przedmiot: listaPrzedmiotow) {
            if (przedmiot.getId().equals(id)) {
                doUsuniecia = przedmiot;
            }
        }
        return listaPrzedmiotow.remove(doUsuniecia);
    }

    public void generujPrzedmioty()
    {
        dodajPrzedmiot(new Przedmiot("Metodologie obiektowe", 2, 216, true, "Tworzenie modelu obiektowego aplikacji" ));
        dodajPrzedmiot(new Przedmiot("Testowanie oprogramowania", 1, 216, false, "Tworzenie scenariuszy testowych i pisanie testow jednostkowych" ));
        dodajPrzedmiot(new Przedmiot("Technologie i aplikacje webowe", 3, 208, false, "Tworzenie serwera http w technologii Java" ));
        dodajPrzedmiot(new Przedmiot("Zarzadzanie projektem informatycznym", 2, 216, false, "Harmonogramowanie, kontrola zasobow i sciezka krytyczna" ));
        dodajPrzedmiot(new Przedmiot("Zaawansowane technologie bazodanowe", 3, 208, false, "Normalizacja, tranzakcje oraz funkcje i porcedury w MySQL" ));
        dodajPrzedmiot(new Przedmiot("Technologie komponentowe i sieciowe", 2, 208, true, "Programowanie aplikacji desktopowej w C#" ));

    }

    public List<Przedmiot> pobierzPrzedmioty(Integer id, Integer sala, Boolean egzamin)
    {
        List<Przedmiot> przefiltrowanePrzedmioty = new ArrayList<>(listaPrzedmiotow);
        if (id != null)
        {
            przefiltrowanePrzedmioty = przefiltrowanePrzedmioty.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
        }
        if (sala != null)
        {
            przefiltrowanePrzedmioty = przefiltrowanePrzedmioty.stream().filter(e -> e.getSala().equals(sala)).collect(Collectors.toList());
        }
        if (egzamin != null)
        {
            przefiltrowanePrzedmioty = przefiltrowanePrzedmioty.stream().filter(e -> e.getEgzamin().equals(egzamin)).collect(Collectors.toList());
        }
        return przefiltrowanePrzedmioty;
    }

    public Przedmiot pobierzPrzedmiotId(Integer id)
    {
        for (Przedmiot przedmiot : listaPrzedmiotow)
        {
            if (przedmiot.getId().equals(id))
            {
                return przedmiot;
            }
        }
        return null;
    }


    public Przedmiot pobierzOstatniPrzedmiot()
    {
        return listaPrzedmiotow.get(listaPrzedmiotow.size() - 1);
    }


}
