package Entidades;

import Enums.SexType;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.lang.Short.valueOf;

public class Athlete {

    private BigInteger id;//los valores son mas grandes que long
    private String name;
    private SexType sex;
    private float height;
    private float weight;
    private ArrayList<AthleteOlympicParticipation> medallas;
    private int medallasOro;
    private int medallasPlata;
    private int medallasBronze;

    private Team equipo;

    public Athlete(String id, String name, String sex, String height, String weight, String team,String NOC) {
        SexType sexType = SexType.valueof(sex);

        this.id = new BigInteger(id);
        this.name = name;
        this.sex = sexType;
        if(!height.equals("NA")) {
            this.height = valueOf(height);
        }
        else{
            this.height = 0;
        }
        if(!weight.equals("NA")) {
            this.weight = Float.parseFloat(weight);
        }
        else{
            this.weight = 0;
        }

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ArrayList<AthleteOlympicParticipation> getMedallas() {
        return medallas;
    }

    public void setMedallas(ArrayList<AthleteOlympicParticipation> medallas) {
        this.medallas = medallas;
    }

    public int getMedallasOro() {
        return medallasOro;
    }

    public void setMedallasOro(int medallasOro) {
        this.medallasOro = medallasOro;
    }

    public int getMedallasPlata() {
        return medallasPlata;
    }

    public void setMedallasPlata(int medallasPlata) {
        this.medallasPlata = medallasPlata;
    }

    public int getMedallasBronze() {
        return medallasBronze;
    }

    public void setMedallasBronze(int medallasBronze) {
        this.medallasBronze = medallasBronze;
    }

    public Team getEquipo() {
        return equipo;
    }

    public void setEquipo(Team equipo) {
        this.equipo = equipo;
    }
}
