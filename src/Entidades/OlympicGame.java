package Entidades;

import Enums.SeasonType;

import java.util.ArrayList;
import java.util.LinkedList;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    private ArrayList participacionesMasculinos;
    private ArrayList participantesFemeninos;
    private City city;
    private LinkedList<Event> event;
    private int CantAtletasFemeninos=participantesFemeninos.size();

    public OlympicGame(String name, int year, SeasonType season, ArrayList participacionesMasculinos, ArrayList participantesFemeninos, City city, LinkedList<Event> event) {
        this.name = name;
        this.year = year;
        this.season = season;
        this.participacionesMasculinos = participacionesMasculinos;
        this.participantesFemeninos = participantesFemeninos;
        this.city = city;
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SeasonType getSeason() {
        return season;
    }

    public void setSeason(SeasonType season) {
        this.season = season;
    }

    public ArrayList getParticipacionesMasculinos() {
        return participacionesMasculinos;
    }

    public void setParticipacionesMasculinos(ArrayList participacionesMasculinos) {
        this.participacionesMasculinos = participacionesMasculinos;
    }

    public ArrayList getParticipantesFemeninos() {
        return participantesFemeninos;
    }

    public void setParticipantesFemeninos(ArrayList participantesFemeninos) {
        this.participantesFemeninos = participantesFemeninos;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LinkedList<Event> getEvent() {
        return event;
    }

    public int getCantAtletasFemeninos() {
        return CantAtletasFemeninos;
    }

    public void setCantAtletasFemeninos(int cantAtletasFemeninos) {
        CantAtletasFemeninos = cantAtletasFemeninos;
    }

    public void setEvent(LinkedList<Event> event) {
        this.event = event;
    }


}
