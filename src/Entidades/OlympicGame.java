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
    private String city;
    //private LinkedList<Event> event;
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

    public OlympicGame(String name, int year) {
        this.name = name;
        this.year = year;
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


