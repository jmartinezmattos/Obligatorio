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
    private String NOC;
    protected ArrayList<AthleteOlympicParticipation> medallas = new ArrayList<>(10);
    private byte medallasOro = 0;
    private byte medallasPlata = 0;
    private byte medallasBronce = 0;
    private int medallasTotales= 0;
    private String team;
    private short minYear = 0;//anio maximo y minimo
    private short maxYear = 0;
    //private Team equipo;


    public Athlete(String id, String name, String sex, String height, String weight, String team,String NOC) {
        SexType sexType = SexType.valueof(sex);
        this.team = team;
        this.NOC = NOC;
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
        //this.noc.setName(NOC);

    }

    public void addParticipacion(AthleteOlympicParticipation participation){
        medallas.add(participation);
        if(participation.getYear()>this.maxYear){
            this.maxYear = participation.getYear();
        }
        if(this.minYear==0||participation.getYear()<this.minYear){
            this.minYear = participation.getYear();
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

    public void agregarMedallaTotales(){
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

    public ArrayList<AthleteOlympicParticipation> getMedallas() {
        return medallas;
    }

    public ArrayList<AthleteOlympicParticipation> getParticipaciones() {
        return medallas;
    }

    public String getNOC() {
        return NOC;
    }

    public String getTeam() {
        return team;
    }

    public int getMinYear() {
        return minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public int getMedallasTotales() {
        return medallasBronce+medallasPlata+medallasOro;
    }
}
