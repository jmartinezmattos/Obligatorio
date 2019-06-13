package Entidades;

import java.util.ArrayList;

public class NationalOlympicCommittee {

    private String name;
    private String region;
    private ArrayList<Athlete> athletes;
    private int cantMedallasOro;
    private int cantMedllasPlata;
    private int cantMedallasBronce;

    public NationalOlympicCommittee(String name, String region) {
        this.name = name;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(ArrayList<Athlete> athletes) {
        this.athletes = athletes;
    }

    public int getCantMedallasOro() {
        return cantMedallasOro;
    }

    public void setCantMedallasOro(int cantMedallasOro) {
        this.cantMedallasOro = cantMedallasOro;
    }

    public int getCantMedllasPlata() {
        return cantMedllasPlata;
    }

    public void setCantMedllasPlata(int cantMedllasPlata) {
        this.cantMedllasPlata = cantMedllasPlata;
    }

    public int getCantMedallasBronce() {
        return cantMedallasBronce;
    }

    public void setCantMedallasBronce(int cantMedallasBronce) {
        this.cantMedallasBronce = cantMedallasBronce;
    }
}
