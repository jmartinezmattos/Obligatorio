package Entidades;

import Entidades.Athlete;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Athlete> Atletas = new ArrayList<>(100);



    public void addAtleta(Athlete athlete){
        this.Atletas.add(athlete);;
    }

    public int getCantidadAtletas(){
        return this.Atletas.size();
    }

    public String getName() {
        return name;
    }

    public boolean equals(Team team){
        boolean result = false;
        if(team.getName().equals(this.name)){
            result = true;
        }
        return result;
    }

    public Team(String name, ArrayList atletas) {
        this.name = name;
        Atletas = atletas;
    }

    public Team(String name){
        this.name = name;
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

    public int[] efectivivadRangoDetalle(int inicio, int fin){
    //devuelve un array que contiene la cantidad de medallas y la cantidad de ateletas en un cierto rango de anios
        int medallas = 0;
        int atletaEnRango = 0;
        boolean atletaContado = false;

        if(inicio<=fin){//se fija que la fecha sea valida

            for(int i=0;i<Atletas.size();i++) {//recorre todos los atletas del equipo
                Athlete athlete = Atletas.get(i);
                for(int b=0;b<athlete.medallas.size();b++){//recorre todas las participaciones del atleta (pueden o no tener medalla)

                    if(inicio<athlete.medallas.get(b).getYear() && athlete.medallas.get(b).getYear()<fin){
                        if(!atletaContado){//si el atleta no esta contado se agrega un atleta
                                atletaEnRango++;
                                atletaContado = true;
                        }
                        if(!athlete.getMedallas().get(b).getMedal().equals("NA")){//si la medalla no es igual a NA se suma una medalla
                            medallas++;
                        }
                    }
                }
                atletaContado = false;//cuando se sale del atleta pasa a false
            }

        }

        int[] result = {atletaEnRango,medallas};
        return result;
    }

    public float efectividadRango(int inicio, int fin){
        //devuelve la efectividad
        int[] datos = efectivivadRangoDetalle(inicio, fin);
        float medallas = datos[1];
        float atletas = datos[0];
        if(datos[0] == 0) {
            return 0;
        }
        else{
            return (medallas / atletas);
        }
    }


}
