package Entidades;

import TADS.Queue.SimpleQueue.SimpleLinkQueueIMP;

public class City {
    private String name;
    private SimpleLinkQueueIMP<OlympicGame> olimpicGame;


    public City(String name, SimpleLinkQueueIMP<OlympicGame> olimpicGame) {
        this.name = name;
        this.olimpicGame = olimpicGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleLinkQueueIMP<OlympicGame> getOlimpicGame() {
        return olimpicGame;
    }

    public void setOlimpicGame(SimpleLinkQueueIMP<OlympicGame> olimpicGame) {
        this.olimpicGame = olimpicGame;
    }
}
