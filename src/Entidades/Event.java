package Entidades;

import Enums.SexType;

import java.util.ArrayList;
import java.util.LinkedList;

//esto es una competicion
public class Event {
    private String name;
    private String sport;
    private String olympicGame;
    private int atletasFemeninos = 0;
    private int atletasMasculinos = 0;
    private LinkedList<Athlete> athletes = new LinkedList<>();

    public Event(String name, String sport, String olympicGame) {
        this.name = name;
        this.sport = sport;
        this.olympicGame = olympicGame;
    }
    public void addAtleta(Athlete athlete){
        athletes.add(athlete);
        if(athlete.getSex().equals(SexType.FEMALE)){
            atletasFemeninos++;
        }
        if(athlete.getSex().equals(SexType.MALE)){
            atletasMasculinos++;
        }
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public int getAtletasFemeninos() {
        return atletasFemeninos;
    }

    public int getAtletasMasculinos() {
        return atletasMasculinos;
    }


}
