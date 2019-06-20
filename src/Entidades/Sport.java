package Entidades;

import java.util.ArrayList;

public class Sport {

    private String name;

    private ArrayList<Event> eventos;
    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
