package Entidades;

import Enums.MedalType;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class AthleteOlympicParticipation {

    private MedalType medal = MedalType.NA;
    private Athlete athlete;
    private int age;
    private  int year;
    private Event event;
    private OlympicGame olympicGame;
    private NationalOlympicCommittee nationalCommitee;


    public AthleteOlympicParticipation(String medal, Athlete athlete,String age,String year) {

        this.year = valueOf(year);

        if(medal.equals("NA")){
            this.medal = MedalType.NA;
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
            this.age = valueOf(age);
        }
        else{
            this.age = 0;
        }
        if(!age.equals("NA")){
            this.age = parseInt(age);
        }
    }

    public int getAge() {
        return age;
    }

    public MedalType getMedal() {
        return medal;
    }

    public OlympicGame getOlympicGame() {
        return olympicGame;
    }

    public int getYear() {
        return year;
    }
}
