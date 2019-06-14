package Entidades;

import Entidades.Athlete;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Athlete> Atletas = new ArrayList<>(100);

    public void addAtleta(Athlete athlete){
        this.Atletas.add(athlete);
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

        int medallas = 0;
        int atletaEnRango = 0;
        boolean atletaContado = false;
        if(inicio<=fin){
            for(int i=0;i<Atletas.size();i++) {
                Athlete athlete = Atletas.get(i);
                for(int b=0;b<athlete.medallas.size();b++){
                    if(inicio<athlete.medallas.get(b).getAge() && athlete.medallas.get(b).getAge()<fin){
                            if(!atletaContado){
                                atletaEnRango++;
                                atletaContado = true;
                            }
                        if(!athlete.medallas.get(b).getMedal().equals("NA")){
                            medallas++;
                        }
                    }
                }
                atletaContado = false;
            }
        }
        int[] result = {atletaEnRango,medallas};
        return result;
    }

    public int efectividadRango(int inicio, int fin){
        int[] datos = efectivivadRangoDetalle(inicio, fin);
        return (datos[0]/datos[1]);
    }
}
