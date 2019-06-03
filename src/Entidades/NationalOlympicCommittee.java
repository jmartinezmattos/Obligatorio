package Entidades;

import Entidades.Athlete;

import java.util.ArrayList;

public class NationalOlympicCommittee {

    private String name;
    private String region;
    private ArrayList<Athlete> athletes;

    public NationalOlympicCommittee(String name, String region) {
        this.name = name;
        this.region = region;
    }
}
