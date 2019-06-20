package Entidades;

import Enums.SeasonType;
import Enums.SexType;

import java.util.ArrayList;
import java.util.LinkedList;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    private ArrayList participantes;
    private String city;
    private String event;
    private int CantAtletasFemeninos=0;

    public OlympicGame(String name, int year, SeasonType season, ArrayList participantes, City city, LinkedList<Event> event) {
        this.name = name;
        this.year = year;
        this.season = season;
        // this.participacionesMasculinos = participacionesMasculinos;
        this.participantes = participantes;
        //this.city = city;
        //this.event = event;
    }

    public OlympicGame(AthleteOlympicParticipation participacion){
        this.name = participacion.getOlympicGame();
        this.year = participacion.getYear();
        this.season = participacion.getSeason();
        this.city = participacion.getCity();
        this.event = participacion.getEvent();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getCantAtletasFemeninos() {
        return CantAtletasFemeninos;
    }

    public void addFemAthlete(){
        CantAtletasFemeninos++;
    }
    }


