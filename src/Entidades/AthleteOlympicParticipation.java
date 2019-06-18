package Entidades;

import Enums.MedalType;
import Enums.SeasonType;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class AthleteOlympicParticipation {

    private MedalType medal = MedalType.NA;
    private Athlete athlete;
    private byte age;
    private short year;
    private String event;
    private String olympicGame;
    private OlympicGame oGames;
    private NationalOlympicCommittee nationalCommitee;
    private String sport;
    private SeasonType season;
    private String city;



    public AthleteOlympicParticipation(String medal, Athlete athlete,String age,String year, String sport,String olympicGame, String event, String season, String city) {

        this.year = Short.parseShort(year);
        this.olympicGame = olympicGame;
        this.event = event;
        this.city = city;

        if(season.equals("Summer")) {
            this.season = SeasonType.SUMMER;
        }
        if(season.equals("Winter")){
            this.season = SeasonType.WINTER;
        }

        this.sport = sport;

        if(medal.equals("NA")){
            this.medal = MedalType.NA;
            athlete.agregarMedallaTotales();
        }
        if(medal.equals("Gold")){
            this.medal = MedalType.GOLD;
            athlete.agregarMedallaOro();
        }
        if(medal.equals("Silver")){
            this.medal = MedalType.SILVER;
            athlete.agregarMedallaPlata();
        }
        if(medal.equals("Bronze")){
            this.medal = MedalType.BRONZE;
            athlete.agregarMedallaBronce();
        }

        this.athlete = athlete;
        if(!age.equals("NA")) {
            this.age = Byte.valueOf(age);
        }
        else{
            this.age = 0;
        }
    }

    public MedalType getMedal() {
        return medal;
    }

    public String getOlympicGame() {
        return olympicGame;
    }

    public short getYear() {
        return year;
    }

    public String getEvent() {
        return event;
    }

    public String getSport() {
        return sport;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public SeasonType getSeason() {
        return season;
    }

    public String getCity() {
        return city;
    }
}
