package Entidades;

import Enums.SeasonType;
import Enums.SexType;

import java.util.ArrayList;
import java.util.LinkedList;

public class OlympicGame {
    private String name;
    private int year;
    private SeasonType season;
    // private ArrayList participacionesMasculinos;
    private ArrayList participantes;
    private City city;
    private LinkedList<Event> event;
    private int CantAtletasFemeninos=0;

    public OlympicGame(String name, int year, SeasonType season, ArrayList participantes, City city, LinkedList<Event> event) {
        this.name = name;
        this.year = year;
        this.season = season;
        // this.participacionesMasculinos = participacionesMasculinos;
        this.participantes = participantes;
        this.city = city;
        this.event = event;
    }

    public OlympicGame(String name, int year) {
        this.name = name;
        this.year = year;
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

    public ArrayList getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList participantes) {
        this.participantes = participantes;
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



      /*


                for(int j=0;j<atleta.getParticipaciones().size();j++){//recorre todas las participaciones
                    AthleteOlympicParticipation participation = atleta.getParticipaciones().get(j);
                    OlympicGame olimpiada = participation.getoGames();
                    if(!olimpiadasFemeninas.contains(olimpiada.getName())){//si la olimpiada no esta en el hash
                        //hay que sumarle uno al contador de atletas femeninos de la olimpiada
                        arrayListOlimpiadasFemeninas.add(olimpiada);//arraylis utilizado para luego recorrer el hash
                        // olimpiadasFemeninas.put(nombreOlimpiada,olimpiada);
                    }
                    else{
                        // OlympicGame olimpiada = olimpiadasFemeninas.find(olimpiada);
                        //hay que agregarle uno a la cantidad  de atletas femeninos
                    }
*/
    }


