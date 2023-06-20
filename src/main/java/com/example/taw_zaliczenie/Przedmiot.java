package com.example.taw_zaliczenie;

public class Przedmiot {

    private static Integer licznik = 0;

    private Integer id;
    private String nazwia;

    private Integer ects;

    private Integer sala;

    private Boolean egzamin;

    public Przedmiot()
    {
        this.id = ++licznik;
    }
    public Przedmiot(String nazwia, Integer ects, Integer sala, Boolean egzamin) {
        this.id = ++licznik;
        this.nazwia = nazwia;
        this.ects = ects;
        this.sala = sala;
        this.egzamin = egzamin;
    }
}
