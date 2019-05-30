import Enums.MedalType;

import static java.lang.Integer.valueOf;

public class AthleteOlympicParticipation {

    private MedalType medal;
    private Athlete athlete;
    private int age;
    //Event event;
    //OlympicGame olympicGame;

    public AthleteOlympicParticipation(String medal, Athlete athlete,String age) {

        MedalType medalType = null;
        medalType = MedalType.valueof(medal);

        this.medal = medalType;
        this.athlete = athlete;
        this.age = valueOf(age);
    }
}
