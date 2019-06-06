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

    public int getCantidadAtletas() {
        return this.Atletas.size();
    }

    public Team(String name, ArrayList atletas) {
        this.name = name;
        Atletas = atletas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getAtletas() {
        return Atletas;
    }

    public void setAtletas(ArrayList atletas) {
        Atletas = atletas;
    }
}
