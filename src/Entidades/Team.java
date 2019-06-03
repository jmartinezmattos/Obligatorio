package Entidades;

import Entidades.Athlete;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList Atletas;
    //int cantidadCompetidores = 0;

    public void addAtleta(Athlete athlete){
        this.Atletas.add(athlete);
    }

    public int getCantidadAtletas(){
        return this.Atletas.size();
    }
}
