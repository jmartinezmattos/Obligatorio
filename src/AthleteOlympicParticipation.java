import Enums.MedalType;

import static java.lang.Integer.valueOf;

public class AthleteOlympicParticipation {

    private MedalType medal;
    private Athlete athlete;
    private int age;
    //Event event;
    //OlympicGame olympicGame;

    public AthleteOlympicParticipation(String medal, Athlete athlete,String age) {


        if(medal.equals("NA")){
            this.medal = MedalType.NA;
        }
        if(medal.equals("Gold")){
            this.medal = MedalType.GOLD;
        }
        if(medal.equals("Silver")){
            this.medal = MedalType.SILVER;
        }
        if(medal.equals("Bronze")){
            this.medal = MedalType.BRONZE;
        }

        this.athlete = athlete;
        if(!age.equals("NA")) {
            this.age = valueOf(age);
        }
        else{
            this.age = 0;
        }
    }
}
