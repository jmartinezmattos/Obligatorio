package Entidades;

import java.util.ArrayList;
import java.util.LinkedList;

public class NationalOlympicCommittee {

    private String name;
    private String NOC;
    private String notes = null;
    private LinkedList<Athlete> athletes = new LinkedList<>();
    private int cantMedallasOro;
    private int cantMedallasPlata;
    private int cantMedallasBronce;


    public NationalOlympicCommittee(String NOC, String region, String notes) {
        this.name = region;
        this.NOC = NOC;
        this.notes = notes;
    }

    public void addAthlete(Athlete athlete){
        this.athletes.add(athlete);
        this.cantMedallasOro = cantMedallasOro + athlete.getMedallasOro();
        this.cantMedallasPlata = cantMedallasPlata + athlete.getMedallasPlata();
        this.cantMedallasBronce = cantMedallasBronce + athlete.getMedallasBronze();
    }

    public String getName() {
        return name;
    }

    public String getNOC() {
        return NOC;
    }

    public int getCantMedallasOro() {
        return cantMedallasOro;
    }

    public void setCantMedallasOro(int cantMedallasOro) {
        this.cantMedallasOro = cantMedallasOro;
    }

    public int getCantMedllasPlata() {
        return cantMedallasPlata;
    }

    public void setCantMedllasPlata(int cantMedllasPlata) {
        this.cantMedallasPlata = cantMedllasPlata;
    }

    public int getCantMedallasBronce() {
        return cantMedallasBronce;
    }

    public void setCantMedallasBronce(int cantMedallasBronce) {
        this.cantMedallasBronce = cantMedallasBronce;
    }
}
