package Entidades;

public class Event {
    private String name;
    private Sport sport;
    private OlympicGame olympicGame;

    public Event(String name, Sport sport, OlympicGame olympicGame) {
        this.name = name;
        this.sport = sport;
        this.olympicGame=olympicGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
