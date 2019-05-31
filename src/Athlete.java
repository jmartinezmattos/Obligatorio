import Enums.SexType;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.lang.Short.valueOf;

public class Athlete {

    private BigInteger id;//los valores son mas grandes que long
    private String name;
    private SexType sex;
    private float height;
    private float weight;
    private ArrayList<AthleteOlympicParticipation> participations;

    Team equipo;

    public Athlete(String id, String name, String sex, String height, String weight) {
        SexType sexType = SexType.valueof(sex);

        this.id = new BigInteger(id);
        this.name = name;
        this.sex = sexType;
        if(!height.equals("NA")) {
            this.height = valueOf(height);
        }
        else{
            this.height = 0;
        }
        if(!weight.equals("NA")) {
            this.weight = Float.parseFloat(weight);
        }
        else{
            this.weight = 0;
        }
    }
}
