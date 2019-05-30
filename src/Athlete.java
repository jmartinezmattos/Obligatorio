import Enums.SexType;

import java.util.ArrayList;

import static java.lang.Short.valueOf;

public class Athlete {

    private long id;
    private String name;
    private SexType sex;
    private float height;
    private float weight;
    private ArrayList<AthleteOlympicParticipation> participations;

    Team equipo;

    public Athlete(String id, String name, String sex, String height, String weight) {

        SexType sexType = SexType.valueof(sex);

        //if(sex.equals("M")){
        //    sexType = SexType.MALE;
        //}

        this.id = valueOf(id);
        this.name = name;
        this.sex = sexType;
        this.height = valueOf(height);
        this.weight = valueOf(weight);
    }
}
