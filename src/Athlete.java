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

        SexType sexType = null;
        sexType=sexType.valueOf(sex);

        this.id = valueOf(id);
        this.name = name;
        this.sex = sexType;
        this.height = valueOf(height);
        this.weight = valueOf(weight);
    }
}
