package Entidades;

import java.util.ArrayList;

public class NationalOlympicCommittee {

    private String name;
    private String NOC;
    private String notes = null;
    private ArrayList<Athlete> athletes;
    private String medallasTotales;


    public NationalOlympicCommittee(String NOC, String region, String notes) {
        this.name = name;
        this.NOC = NOC;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return NOC;
    }

    public void setRegion(String region) {
        this.NOC = region;
    }

    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(ArrayList<Athlete> athletes) {
        this.athletes = athletes;
    }
}
