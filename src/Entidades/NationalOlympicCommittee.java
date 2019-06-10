package Entidades;

import java.util.ArrayList;

public class NationalOlympicCommittee {

    private String name;
    private String region;
    private ArrayList<Athlete> athletes;

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
}
