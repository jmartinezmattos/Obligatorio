package Entidades;

import Enums.SexType;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.lang.Short.valueOf;

public class Athlete  {

    private BigInteger id;//los valores son mas grandes que long
    private String name;
    private SexType sex;
    private float height;
    private float weight;
    private ArrayList<AthleteOlympicParticipation> medallas;
    private int medallasOro = 0;
    private int medallasPlata = 0;
    private int medallasBronce = 0;
    private int medallasTotales = 0;
    //private Team equipo;

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

    public String getName() {
        return name;
    }

    public SexType getSex() {
        return sex;
    }

    public int getMedallasOro() {
        return medallasOro;
    }

    public int getMedallasPlata() {
        return medallasPlata;
    }

    public int getMedallasBronze() {
        return medallasBronce;
    }

    public void agregarMedallaOro(){
        this.medallasOro++;
        this.medallasTotales++;
    }

    public void agregarMedallaPlata(){
        this.medallasPlata++;
        this.medallasTotales++;
    }

    public void agregarMedallaBronce(){
        this.medallasBronce++;
        this.medallasTotales++;
    }





}
