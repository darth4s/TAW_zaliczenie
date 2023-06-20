package com.example.taw_zaliczenie;

public class Przedmiot {

    private static Integer licznik = 0;

    private Integer id;
    private String nazwa;

    private Integer ects;

    private Integer sala;

    private Boolean egzamin;

    private String opis;

    public Przedmiot()
    {
        this.id = ++licznik;
    }
    public Przedmiot(String nazwa, Integer ects, Integer sala, Boolean egzamin, String opis) {
        this.id = ++licznik;
        this.nazwa = nazwa;
        this.ects = ects;
        this.sala = sala;
        this.egzamin = egzamin;
        this.opis = opis;
    }

    public static Integer getLicznik() {
        return licznik;
    }

    public static void setLicznik(Integer licznik) {
        Przedmiot.licznik = licznik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Boolean getEgzamin() {
        return egzamin;
    }

    public void setEgzamin(Boolean egzamin) {
        this.egzamin = egzamin;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
